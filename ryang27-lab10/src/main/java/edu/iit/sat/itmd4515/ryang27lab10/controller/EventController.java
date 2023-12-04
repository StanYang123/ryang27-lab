package edu.iit.sat.itmd4515.ryang27lab10.controller;

import edu.iit.sat.itmd4515.ryang27lab10.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab10.service.impl.EventServiceImpl;
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

    public String add(){
        return "/event-form.xhtml?faces-redirect=true";
    }

    public String update(){
        return "/event-update.xhtml?faces-redirect=true";
    }

    public String delect(){
        return "/event-delect.xhtml?faces-redirect=true";
    }

    public String delect1(){
        System.out.println(event.getId());
        eventService.deleteById(event.getId());
        return "/event-list.xhtml?faces-redirect=true";
    }

    public String update1(){
        Event event1 = new Event();
        event1.setId(event.getId());
        event1.setName(event.getName());
        event1.setType(event.getType());

        eventService.update(event1);

        return "/event-list.xhtml?faces-redirect=true";
    }



    public Event getEvent() {
        return event;
    }



}
