package edu.iit.sat.itmd4515.ryang27lab10.service.impl;

import edu.iit.sat.itmd4515.ryang27lab10.service.EventService;
import edu.iit.sat.itmd4515.ryang27lab10.pojo.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ryang27
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
    public void update(Event event) {
        System.out.println(event.toString());
        entityManager.merge(event);
        entityManager.flush();
    }

    @Transactional
    public void deleteById(long id) {
        Event event = select(Integer.valueOf(String.valueOf(id)));
        if (event != null) {
            entityManager.remove(event);
        }
    }

    @Transactional
    public Event save(Event event) {
        entityManager.persist(event);
        return event;
    }

    public Event select(Integer id){
        Event event = (Event) entityManager.find(Event.class, id);
        return event;
    }


}
