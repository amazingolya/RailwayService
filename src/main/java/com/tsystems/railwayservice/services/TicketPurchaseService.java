package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Ticket;

public interface TicketPurchaseService {

    Ticket buyTicket(long trainId, long passengerId, long departureStationId, long arrivalStationId);
}
