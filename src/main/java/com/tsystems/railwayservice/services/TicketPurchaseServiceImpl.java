package com.tsystems.railwayservice.services;

import com.tsystems.railwayservice.entities.Passenger;
import com.tsystems.railwayservice.entities.Ticket;
import com.tsystems.railwayservice.entities.Train;
import com.tsystems.railwayservice.exceptions.PurchaseException;
import com.tsystems.railwayservice.repositories.PassengerDao;
import com.tsystems.railwayservice.repositories.ScheduleDao;
import com.tsystems.railwayservice.repositories.TicketDao;
import com.tsystems.railwayservice.repositories.TrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class TicketPurchaseServiceImpl implements TicketPurchaseService {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private PassengerDao passengerDao;

    private boolean checkTime(long trainId, long departureStationId) {
        long departureTime = scheduleDao.getByTrainAndStation(trainId, departureStationId).getDepartureTime();
        long currentTime = System.currentTimeMillis();

        if ((departureTime - currentTime) < 600000) {
            return false;
        }
        return true;
    }

    @Override
    public Ticket buyTicket(long trainId, long departureStationId, long arrivalStationId, String name,
                            String surname, String dateOfBirth, double price) throws PurchaseException {
        if (!checkTime(trainId, departureStationId)) {
            throw new PurchaseException("Less than 10 min left before train leaves!");
        }

        if (ticketDao.getVacantSeats(trainId).isEmpty()) {
            throw new PurchaseException("No vacant seats left!");
        }

        if (!passengerDao.checkPassengerOnTrain(name, surname, dateOfBirth, trainId)) {
            throw new PurchaseException("Passenger with this personal info is already registered on this train!");
        }

        Passenger passenger = passengerDao.checkPassenger(name, surname, dateOfBirth);
        Train train = trainDao.getById(trainId);
        if (passenger == null) {
            passenger = new Passenger();
            passenger.setName(name);
            passenger.setSurname(surname);
            passenger.setDateOfBirth(dateOfBirth);
            Set<Train> listOfTrains = new HashSet<>();
            listOfTrains.add(train);
            passenger.setTrains(listOfTrains);
            passengerDao.add(passenger);

        } else {
            Set<Train> trainSet = passenger.getTrains();
            trainSet.add(train);
            passenger.setTrains(trainSet);
            passengerDao.update(passenger);
        }

        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setTrain(train);
//        ticket.setPrice();
//        ticket.setSeatNumber();
        ticketDao.add(ticket);
        return ticket;
    }

}
