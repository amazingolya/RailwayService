package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.Ticket;
import org.javatuples.Pair;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.tsystems.railwayservice.entities.Price.TicketType;

@Repository
public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<TicketType, Integer>  getVacantSeats(long trainId) {

        Query query = entityManager.createQuery("SELECT ticket_type, count(*) " +
                "FROM Price JOIN Ticket ON Price.price_id = Ticket.price_Id" +
                " WHERE Ticket.train_id = :trainId GROUP BY ticket_type")
                .setParameter("trainId", trainId);
        List<Pair> takenSeats = query.getResultList();

        Query query1 = entityManager.createQuery("SELECT ticket_type, count(*) " +
                "FROM Train_seats WHERE Ticket.train_id = :trainId GROUP BY ticket_type")
                .setParameter("trainId", trainId);
        List<Pair> allSeats = query1.getResultList();

        Map<TicketType, Integer> vacantSeats = new HashMap<>();
        for (Pair pair: takenSeats) {
            vacantSeats.put((TicketType) pair.getValue0(), (Integer) pair.getValue1());
        }

        for (Pair pair: allSeats) {
            TicketType type = (TicketType) pair.getValue0();

            for (Map.Entry<TicketType, Integer> entry: vacantSeats.entrySet()) {
                if (type == entry.getKey()) {
                    vacantSeats.put(type, (Integer) pair.getValue1() - entry.getValue());
                }
            }
        }
        return vacantSeats;
    }

    @Override
    public int getLastVacantSeat(double price, long trainId) {
//        Query query = entityManager.createQuery("SELECT seat_number FROM Ticket JOIN Price ON ");
        return 0;
    }
}