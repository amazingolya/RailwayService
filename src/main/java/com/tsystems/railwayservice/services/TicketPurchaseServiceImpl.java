package com.tsystems.railwayservice.services;

import com.tsystems.railwayservice.entities.Ticket;
import com.tsystems.railwayservice.repositories.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TicketPurchaseServiceImpl implements TicketPurchaseService {

    @Autowired
    TicketDao ticketDao;

    public boolean checkTime(long trainId, long departureStationId) {
        return false;
    }

    public boolean checkVacantSeats(long trainId, long departureStationId, long arrivalStationId) {
        return false;
    }

    public boolean checkPassengerDuplicates(long passengerId, long trainId) {
        return false;
    }

    @Override
    public Ticket buyTicket(long trainId, long passengerId, long departureStationId, long arrivalStationId) {
        return null;
    }

}
