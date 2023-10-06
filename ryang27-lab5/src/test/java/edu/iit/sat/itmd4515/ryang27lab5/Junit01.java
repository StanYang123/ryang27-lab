package edu.iit.sat.itmd4515.ryang27lab5;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.iit.sat.itmd4515.ryang27lab5.mapper.AnimalMapper;
import edu.iit.sat.itmd4515.ryang27lab5.mapper.EventMapper;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Event;
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
    private EventMapper eventMapper;

    @Autowired
    private AnimalMapper animalMapper;

    @Test
    public void  test01(){
        LambdaQueryWrapper<Event> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Event::getRemark,"10:00");
        Event event = eventMapper.selectOne(wrapper);

        LambdaQueryWrapper<Animal> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(Animal::getEname,event.getName());

        Animal animal = animalMapper.selectOne(wrapper1);
        assertEquals("tiger", animal.getAname());
    }

}
