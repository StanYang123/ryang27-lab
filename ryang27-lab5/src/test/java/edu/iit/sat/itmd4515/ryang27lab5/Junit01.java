package edu.iit.sat.itmd4515.ryang27lab5;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import edu.iit.sat.itmd4515.ryang27lab5.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab5.repository.AnimalRepository;
import edu.iit.sat.itmd4515.ryang27lab5.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Wang.Kone
 * @date 2023/10/6 14:20
 */

@SpringBootTest
public class Junit01 {

      @Autowired
      private EventRepository eventRepository;

      @Autowired
      private AnimalRepository animalRepository;

    @Test
    public void  test01(){
        Event event = eventRepository.findByEvent("New York Zoo");

        Animal animal = animalRepository.selectOne(event.getName());
        assertEquals("tiger", animal.getAname());
    }

}
