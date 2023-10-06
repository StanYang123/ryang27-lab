package edu.iit.sat.itmd4515.ryang27;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import edu.iit.sat.itmd4515.ryang27.se.mapper.EventMapper;
import edu.iit.sat.itmd4515.ryang27.se.pojo.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Wang.Kone
 * @date 2023/10/5 16:18
 */
@SpringBootTest
public class Junit02 {

    @Autowired
    private EventMapper eventMapper;

    @Test
    public void testCreate(){
        Event event = new Event();
        event.setDate(new Date());
        event.setName("Zoo");
        event.setRemark("New York Zoo");
        event.setType("openness");
        eventMapper.insert(event);
    }

    @Test
    public void testRead(){
        List<Event> eventList = eventMapper.selectList(new LambdaQueryWrapper<>());
        System.out.println(eventList.toString());
    }

    @Test
    public void testUpdate(){
        Event event = new Event();
        event.setDate(new Date());
        event.setName("Zoo1");
        event.setRemark("New York Zoo");
        event.setType("openness");
        LambdaUpdateWrapper<Event> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Event::getName,"Zoo");
        eventMapper.update(event,wrapper);
    }

    @Test
    public void testDelete(){
        LambdaQueryWrapper<Event> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Event::getName,"Zoo");
        eventMapper.delete(wrapper);
    }

}
