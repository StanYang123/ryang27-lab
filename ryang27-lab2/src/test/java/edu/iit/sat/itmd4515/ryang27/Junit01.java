package edu.iit.sat.itmd4515.ryang27;

import edu.iit.sat.itmd4515.ryang27.se.pojo.Event;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Wang.Kone
 * @date 2023/10/5 16:18
 */
public class Junit01 {



    @Test
    public void testEvent(){

        Event event = new Event();
        event.setRemark("New York Zoo");
        event.setType("openness");
        validate(event);
    }


    private static void validate(Event desk1) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Event>> validate = validator.validate(desk1);
        for (ConstraintViolation<Event> cv : validate) {
            System.out.println(cv.getRootBean().getClass().getName() + "类的"
                    + cv.getPropertyPath() + "属性 -> " + cv.getMessage());
        }
    }

}
