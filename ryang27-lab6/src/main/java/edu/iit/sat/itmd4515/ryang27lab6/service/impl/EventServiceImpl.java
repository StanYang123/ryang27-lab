package edu.iit.sat.itmd4515.ryang27lab6.service.impl;

import edu.iit.sat.itmd4515.ryang27lab6.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab6.service.EventService;
import jakarta.ejb.Stateless;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wang.Kone
 * @date 2023/10/22 12:57
 */

@Stateless
@Service
public class EventServiceImpl implements EventService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public Event select(){
        Event event = (Event) entityManager.find(Event.class, null);
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
