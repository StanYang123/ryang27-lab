package edu.iit.sat.itmd4515.ryang27lab7.controller;

import edu.iit.sat.itmd4515.ryang27lab7.config.YourManagedBean;
import edu.iit.sat.itmd4515.ryang27lab7.pojo.Usere;
import edu.iit.sat.itmd4515.ryang27lab7.service.impl.UsereServiceImpl;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Wang.Kone
 * @date 2023/11/2 14:54
 */

@Scope(value = "session")
@Service(value = "LoginController")
@ELBeanName(value = "LoginController")
@Join(path = "/login", to = "/login.jsf")
@Component
@RequestScoped
public class LoginController  extends SpringBeanAutowiringSupport {

    @Autowired
    private UsereServiceImpl usereService;


    private SecurityContext securityContext;

    @PostConstruct
    private void init() {
        System.out.println(securityContext);
    }


    private Usere usere = new Usere();

    public String login() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        securityContext = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{securityContext}", SecurityContext.class);
        System.out.println(securityContext);

        if (usere.getUsername().length()==0||usere.getPassword().equals("")){
            return "/error.xhtml?faces-redirect=true";
        }
        //login
        Usere usere1 = usereService.select(usere.getUsername(),usere.getPassword());

        if (usere1==null){
            return "/error.xhtml?faces-redirect=true";
        }

        return "/welcome.xhtml?faces-redirect=true";

    }

    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        try {
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            request.logout();
        } catch (ServletException ex) {
        }

        return "/login.xhtml?faces-redirect=true";
    }

    public Usere getUsere() {
        return usere;
    }


}
