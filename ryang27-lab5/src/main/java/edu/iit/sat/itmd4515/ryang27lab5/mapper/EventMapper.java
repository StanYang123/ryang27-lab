package edu.iit.sat.itmd4515.ryang27lab5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Event;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 神舟笔记本
* @description 针对表【event】的数据库操作Mapper
* @createDate 2023-10-05 16:07:07
* @Entity edu.iit.sat.itmd4515.ryang27.se.pojo.domain.Event
*/
@Mapper
public interface EventMapper extends BaseMapper<Event> {

}




