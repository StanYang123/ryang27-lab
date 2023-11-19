package edu.iit.sat.itmd4515.ryang27lab10.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Wang.Kone
 * @date 2023/11/19 12:10
 */

@Scope(value = "session")
@Controller(value = "CustomerController")
@Join(path = "/customer", to = "/customer.jsf")
public class CustomerController {

}
