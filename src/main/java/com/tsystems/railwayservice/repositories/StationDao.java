package com.tsystems.railwayservice.repositories;


import com.tsystems.railwayservice.entities.Station;

public interface StationDao extends BaseDao<Station> {

    Station getStationByName(String name);
}
