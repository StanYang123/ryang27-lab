package edu.iit.sat.itmd4515.ryang27lab7.controller;

import edu.iit.sat.itmd4515.ryang27lab7.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab7.service.impl.EventServiceImpl;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Wang.Kone
 * @date 2023/11/2 10:49
 */

@Scope(value = "session")
@Component(value = "EventController")
@ELBeanName(value = "EventController")
@Join(path = "/event", to = "/event-form.jsf")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    private Event event = new Event();

    public String save() {
        if (event.getName().length()==0||event.getType().equals("")){
            return "/answer.xhtml?faces-redirect=true";
        }
        try {
            eventService.save(event);
            event = new Event();
            return "/event-list.xhtml?faces-redirect=true";
        }catch (Exception e){
            return "/answer.xhtml?faces-redirect=true";
        }

    }

    public Event getEvent() {
        return event;
    }



}
