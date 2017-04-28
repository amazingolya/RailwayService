package com.tsystems.railwayservice.repositories;


import com.tsystems.railwayservice.entities.Ticket;

import static com.tsystems.railwayservice.entities.Price.TicketType;
import java.util.Map;

public interface TicketDao extends BaseDao<Ticket> {

    Map<TicketType, Integer> getVacantSeats(long trainId);

    int getLastVacantSeat(double price, long trainId);
}
