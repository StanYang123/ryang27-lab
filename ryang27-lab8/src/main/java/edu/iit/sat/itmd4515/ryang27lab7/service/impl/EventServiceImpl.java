package edu.iit.sat.itmd4515.ryang27lab7.service.impl;

import edu.iit.sat.itmd4515.ryang27lab7.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab7.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Wang.Kone
 * @date 2023/10/22 12:57
 */

@Service
public class EventServiceImpl implements EventService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public List<Event> select(){
        String sql = "select * from event ";
        Query query = entityManager.createNativeQuery(sql, Event.class);
        List<Event> event = query.getResultList();
        return event;
    }

    @Transactional
    public Event update(Event event) {
        entityManager.merge(event);
        return event;
    }

    @Transactional
    public Event save(Event event) {
        entityManager.persist(event);
        return event;
    }


}
