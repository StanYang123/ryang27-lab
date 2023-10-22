package edu.iit.sat.itmd4515.ryang27lab5;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Euser;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab5.repository.EuserRepository;
import edu.iit.sat.itmd4515.ryang27lab5.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Wang.Kone
 * @date 2023/10/6 14:21
 */

@SpringBootTest
public class Junit02 {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EuserRepository euserRepository;

    @Test
    public void test01(){
        List<Euser> list = euserRepository.selectList();

        for (int i=0;i<list.size();i++){
            Event event = eventRepository.findByEvent1(list.get(i).getEname());
            assertEquals("Zoo", event.getName());
        }

        Event event = eventRepository.findByEvent("10:00");

        List<Euser> list1 = euserRepository.selectListA(event.getName());
        assertEquals("Zoo", list1.get(0).getEname());
    }

}
