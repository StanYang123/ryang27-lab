package edu.iit.sat.itmd4515.ryang27lab9.controller;

import edu.iit.sat.itmd4515.ryang27lab9.pojo.Usere;
import edu.iit.sat.itmd4515.ryang27lab9.service.impl.UsereServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Wang.Kone
 * @date 2023/11/2 14:54
 */

@Scope(value = "session")
@Controller(value = "LoginController")
@Join(path = "/login", to = "/login.jsf")
public class LoginController  extends SpringBeanAutowiringSupport {

    @Autowired
    private UsereServiceImpl usereService;

    @PostConstruct
    private void init() {

    }


    private Usere usere = new Usere();

    public String login() {

        //Test User Role username:user password:123

        if (usere.getUsername().equals("user")||usere.getPassword().equals("123")){
            return "/welcome.xhtml?faces-redirect=true";
        }

        if (usere.getUsername().length()==0||usere.getPassword().equals("")){
            return "/errors/error.xhtml";
        }
        //login
        Usere usere1 = usereService.select(usere.getUsername(),usere.getPassword());

        if (usere1==null){
            return "/errors/error.xhtml";
        }

        return "/welcome.xhtml?faces-redirect=true";

    }

    public String logout() {
        System.out.println("1111");
        return "/login.xhtml?faces-redirect=true";
    }

    public Usere getUsere() {
        return usere;
    }


}
