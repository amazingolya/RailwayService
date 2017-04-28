package com.tsystems.railwayservice.repositories;

import org.springframework.core.GenericTypeResolver;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseDaoImpl<Entity> implements BaseDao<Entity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @ManyToOne(cascade = CascadeType.ALL)
    @SuppressWarnings("unchecked")
    public Set<Entity> getAll() {
        Class<Entity> entityClass = getEntityClass();
        Query query = entityManager.createQuery("from " + entityClass.getSimpleName());
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Entity getById(long id) {
        Class<Entity> entityClass = getEntityClass();
        return entityManager.find(entityClass, id);
    }

    @Override
    public void add(Entity entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Entity entity) {
        entityManager.remove(entity);
    }

    @Override
    public void update(Entity entity) {
        entityManager.merge(entity);
    }

    @SuppressWarnings("unchecked")
    private Class<Entity> getEntityClass() {
        return (Class<Entity>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }
}
