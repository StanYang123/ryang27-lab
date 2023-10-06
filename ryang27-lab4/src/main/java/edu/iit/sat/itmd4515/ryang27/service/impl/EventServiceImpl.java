package edu.iit.sat.itmd4515.ryang27.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.iit.sat.itmd4515.ryang27.mapper.EventMapper;
import edu.iit.sat.itmd4515.ryang27.pojo.Event;
import edu.iit.sat.itmd4515.ryang27.service.EventService;
import org.springframework.stereotype.Service;

/**
* @author 神舟笔记本
* @description 针对表【event】的数据库操作Service实现
* @createDate 2023-10-05 16:07:07
*/
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event>
    implements EventService {

}




