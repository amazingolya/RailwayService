package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Ticket;
import com.tsystems.railwayservice.exceptions.PurchaseException;

public interface TicketPurchaseService {

    Ticket buyTicket(long trainId, long departureStationId, long arrivalStationId, String name,
                     String surname, String dateOfBirth, double price) throws PurchaseException;


}
