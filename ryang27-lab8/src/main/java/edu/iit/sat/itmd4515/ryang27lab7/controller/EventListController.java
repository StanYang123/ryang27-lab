package edu.iit.sat.itmd4515.ryang27lab7.controller;

import edu.iit.sat.itmd4515.ryang27lab7.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab7.service.impl.EventServiceImpl;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;


/**
 * @author Wang.Kone
 * @date 2023/11/2 13:08
 */

@Scope (value = "session")
@Component (value = "EventList")
@ELBeanName(value = "EventList")
@Join(path = "/eventlist", to = "/event-list.jsf")
public class EventListController {

    @Autowired
    private EventServiceImpl eventService;

    private List<Event> events;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
//        List<Event> events1 = new ArrayList<>();
//        events1.add(eventService.select());
//        events = events1;
    }

    public List<Event> getEvents() {
        List<Event> events1 = new ArrayList<>();
//        events1.add(eventService.select());
        events = eventService.select();
        System.out.println(events.size());
        return events;
    }



}
