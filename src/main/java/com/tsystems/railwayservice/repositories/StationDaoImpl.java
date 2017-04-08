package com.tsystems.railwayservice.repositories;


import com.tsystems.railwayservice.entities.Station;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class StationDaoImpl extends BaseDaoImpl<Station> implements StationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Station getStationByName(String name) {
        Query query = entityManager
                .createQuery("select s from Station as s where s.station_name = :name")
                .setParameter("name", name);
        return (Station) query.getSingleResult();
    }
}
