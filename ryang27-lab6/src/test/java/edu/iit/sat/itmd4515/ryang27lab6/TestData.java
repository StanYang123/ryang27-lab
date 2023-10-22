package edu.iit.sat.itmd4515.ryang27lab6;

import edu.iit.sat.itmd4515.ryang27lab6.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab6.pojo.City;
import edu.iit.sat.itmd4515.ryang27lab6.pojo.Euser;
import edu.iit.sat.itmd4515.ryang27lab6.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab6.service.impl.AnimalServiceImpl;
import edu.iit.sat.itmd4515.ryang27lab6.service.impl.CityServiceImpl;
import edu.iit.sat.itmd4515.ryang27lab6.service.impl.EuserServiceImpl;
import edu.iit.sat.itmd4515.ryang27lab6.service.impl.EventServiceImpl;
import jakarta.ejb.EJB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author Wang.Kone
 * @date 2023/10/22 13:06
 */
@SpringBootTest
public class TestData {

    @EJB
    @Autowired
    public AnimalServiceImpl animalService;

    @EJB
    @Autowired
    public CityServiceImpl cityService;

    @EJB
    @Autowired
    public EuserServiceImpl euserService;

    @EJB
    @Autowired
    public EventServiceImpl eventService;

    @Test
    void test() {
        animalService.select(1);
        Animal animal = new Animal();
        animal.setAid(1);
        animalService.save(animal);
        animalService.deleteById(1);
        Animal animal1 = new Animal();
        animal1.setAid(1);
        animalService.update(animal1);
    }

    @Test
    void test1() {
        cityService.select(1);
        City city = new City();
        city.setCid(3);
        cityService.save(city);
        cityService.deleteById(1);
        City city1 = new City();
        city1.setCid(1);
        cityService.update(city1);
    }

    @Test
    void test2() {
        euserService.select(1);
        Euser euser = new Euser();
        euser.setUid(3);

        euserService.save(euser);
        euserService.deleteById(1);
        Euser euser1 = new Euser();
        euser1.setUid(1);
        euserService.update(euser1);
    }

    @Test
    void test3() {
        eventService.select();
        Event event = new Event();
        event.setId(3);
        eventService.save(event);
        Event event1 = new Event();
        event1.setId(1);
        eventService.update(event1);
    }

}
