package edu.iit.sat.itmd4515.ryang27lab10.controller;

import edu.iit.sat.itmd4515.ryang27lab10.pojo.Usere;
import edu.iit.sat.itmd4515.ryang27lab10.service.impl.UsereServiceImpl;
import jakarta.annotation.PostConstruct;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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


    public Usere usere = new Usere();

    public Usere usere2 = new Usere();


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
        return "/login.xhtml?faces-redirect=true";
    }

    public String registerGo(){
        return "/register.xhtml?faces-redirect=true";
    }

    public String register() {
        if (usere2.getUsername().length()==0||usere2.getPassword().equals("")){
            return "/errors/error.xhtml";
        }

        usereService.save(usere2.getUsername(),usere2.getPassword());
        return "/login.xhtml?faces-redirect=true";

    }

    public Usere getUsere() {
        return usere;
    }

    public Usere getUsere2() {
        return usere2;
    }

    public String index(){
        System.out.println("1111");
        return "/login.xhtml?faces-redirect=true";
    }

    public String javadoc(){
        System.out.println("1111");
        return "/javadoc/index.html?faces-redirect=true";
    }

}
