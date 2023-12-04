package edu.iit.sat.itmd4515.ryang27lab10.controller;

import edu.iit.sat.itmd4515.ryang27lab10.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab10.service.impl.EventServiceImpl;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Wang.Kone
 * @date 2023/11/2 13:08
 */

@Scope (value = "session")
@Component (value = "EventListController")
@ELBeanName(value = "EventListController")
@Join(path = "/eventlist", to = "/event-list.jsf")
public class EventListController {

    @Autowired
    private EventServiceImpl eventService;

    private List<Event> events;

    private Event event = new Event();


    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
//        List<Event> events1 = new ArrayList<>();
//        events1.add(eventService.select());
//        events = events1;
    }

    public List<Event> getEvents() {
        System.out.println(event.getId());

        List<Event> events1 = new ArrayList<>();
//        events1.add(eventService.select());
        events = eventService.select();
        if (event.getId()!=null){
            events.clear();
            events=search();
        }
        return events;
    }

    public List<Event> search(){
        if (event.getId()==null){
            return null;
        }
        Event event1 = eventService.select(event.getId());
        if (event1==null){
            getEvent();
            return null;
        }
//        System.out.println(event1.toString());
        events.clear();
        events.add(event1);
        return events;
    }

    public String goError(){
        return "/errors/data.xhtml";

    }

    public Event getEvent() {
        return event;
    }


}
