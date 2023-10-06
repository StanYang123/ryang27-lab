package edu.iit.sat.itmd4515.ryang27lab5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.iit.sat.itmd4515.ryang27lab5.service.AnimalService;
import edu.iit.sat.itmd4515.ryang27lab5.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab5.mapper.AnimalMapper;
import org.springframework.stereotype.Service;

/**
* @author 神舟笔记本
* @description 针对表【animal】的数据库操作Service实现
* @createDate 2023-10-06 14:07:51
*/
@Service
public class AnimalServiceImpl extends ServiceImpl<AnimalMapper, Animal>
    implements AnimalService {

}




