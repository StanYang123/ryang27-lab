package edu.iit.sat.itmd4515.ryang27;

import edu.iit.sat.itmd4515.ryang27.pojo.Event;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Wang.Kone
 */
public class Junit02 {

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
