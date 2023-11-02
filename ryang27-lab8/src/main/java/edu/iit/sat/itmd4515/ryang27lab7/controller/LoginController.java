package edu.iit.sat.itmd4515.ryang27lab7.controller;

import edu.iit.sat.itmd4515.ryang27lab7.config.A;
import edu.iit.sat.itmd4515.ryang27lab7.config.UserPasswordHash;
import edu.iit.sat.itmd4515.ryang27lab7.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab7.pojo.Usere;
import edu.iit.sat.itmd4515.ryang27lab7.service.impl.EventServiceImpl;
import edu.iit.sat.itmd4515.ryang27lab7.service.impl.UsereServiceImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ocpsoft.rewrite.annotation.Join;
import jakarta.security.enterprise.SecurityContext;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.logging.Level;

/**
 * @author Wang.Kone
 * @date 2023/11/2 14:54
 */

@Scope(value = "session")
@Service(value = "LoginController")
@ELBeanName(value = "LoginController")
@Join(path = "/login", to = "/login.jsf")
public class LoginController {

    @Autowired
    private UsereServiceImpl usereService;


    @Autowired
    public SecurityContext securityContext;

    @Autowired
    public FacesContext facesContext;

    @Autowired
    private UserPasswordHash userPasswordHash;

    private Usere usere = new Usere();

    public String login() {
        if (usere.getUsername().length()==0||usere.getPassword().equals("")){
            return "/error.xhtml?faces-redirect=true";
        }
        //login
        Usere usere1 = usereService.select(usere.getUsername(),usere.getPassword());

        if (usere1==null){
            return "/error.xhtml?faces-redirect=true";
        }

        userPasswordHash.passwordHash(usere1);

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        Credential cred = new UsernamePasswordCredential(usere.getUsername(), new Password(usere.getPassword()));

        AuthenticationStatus status
                = securityContext.authenticate(
                request,
                response,
                AuthenticationParameters.withParams().credential(cred)
        );

        System.out.println(status);

        switch (status) {
            case SUCCESS:
                break;
            case SEND_FAILURE:
                return "/error.xhtml?faces-redirect=true";
            case NOT_DONE:
                return "/error.xhtml?faces-redirect=true";
            case SEND_CONTINUE:
                break;
        }

        return "/welcome.xhtml?faces-redirect=true";

    }

    public String logout() {

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
