package edu.iit.sat.itmd4515.ryang27lab9.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Wang.Kone
 * @date 2023/11/19 11:58
 */

@Scope(value = "session")
@Controller(value = "WelcomeController")
@Join(path = "/welcome", to = "/welcome.jsf")
public class WelcomeController {

    public String logout() {
        return "/login.xhtml?faces-redirect=true";
    }

}
