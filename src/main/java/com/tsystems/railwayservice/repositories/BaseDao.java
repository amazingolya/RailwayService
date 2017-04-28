package com.tsystems.railwayservice.repositories;


import java.util.Set;

public interface BaseDao<Entity> {

    Entity getById(long id);

    Set<Entity> getAll();

    void update(Entity entity);

    void add(Entity entity);

    void delete(Entity entity);
}
