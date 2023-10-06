package edu.iit.sat.itmd4515.ryang27lab5;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.iit.sat.itmd4515.ryang27lab5.mapper.AnimalMapper;
import edu.iit.sat.itmd4515.ryang27lab5.mapper.EuserMapper;
import edu.iit.sat.itmd4515.ryang27lab5.mapper.EventMapper;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Euser;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Event;
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
    private EventMapper eventMapper;

    @Autowired
    private EuserMapper euserMapper;

    @Test
    public void test01(){
        LambdaQueryWrapper<Euser> wrapper = new LambdaQueryWrapper<>();
        List<Euser> list = euserMapper.selectList(wrapper);

        for (int i=0;i<list.size();i++){
            LambdaQueryWrapper<Event> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(Event::getName,list.get(i).getEname());
            Event event = eventMapper.selectOne(wrapper1);
            assertEquals("Zoo", event.getName());
        }

        LambdaQueryWrapper<Event> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.eq(Event::getRemark,"10:00");
        Event event = eventMapper.selectOne(wrapper2);
        LambdaQueryWrapper<Euser> wrapper3 = new LambdaQueryWrapper<>();
        wrapper3.eq(Euser::getEname,event.getName());
        List<Euser> list1 = euserMapper.selectList(wrapper3);
    }

}
