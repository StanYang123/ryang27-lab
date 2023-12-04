package edu.iit.sat.itmd4515.ryang27lab10.controller;

import edu.iit.sat.itmd4515.ryang27lab10.pojo.Usere;
import edu.iit.sat.itmd4515.ryang27lab10.service.impl.UsereServiceImpl;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author ryang27
 * @date 2023/11/24 16:09
 * Register User
 */
@Scope(value = "session")
@Controller(value = "RegisterController")
@Join(path = "/register", to = "/register.jsf")
public class RegisterController {

    @Autowired
    private UsereServiceImpl usereService;

    private Usere usere = new Usere();

    public String register() {
        if (usere.getUsername().length()==0||usere.getPassword().equals("")){
            return "/errors/error.xhtml";
        }

       usereService.save(usere.getUsername(),usere.getPassword());
        return "/login.xhtml?faces-redirect=true";

    }

}
