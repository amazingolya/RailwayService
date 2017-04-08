package com.tsystems.railwayservice.repositories;

import java.util.List;

public interface BaseDao<Entity> {

    Entity getById(long id);

    List<Entity> getAll();

    void update(Entity entity);

    void add(Entity entity);

    void delete(Entity entity);
}
