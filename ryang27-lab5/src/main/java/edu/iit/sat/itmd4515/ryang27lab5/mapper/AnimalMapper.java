package edu.iit.sat.itmd4515.ryang27lab5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Animal;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 神舟笔记本
* @description 针对表【animal】的数据库操作Mapper
* @createDate 2023-10-06 14:07:51
* @Entity generator.domain.Animal
*/
@Mapper
public interface AnimalMapper extends BaseMapper<Animal> {

}




