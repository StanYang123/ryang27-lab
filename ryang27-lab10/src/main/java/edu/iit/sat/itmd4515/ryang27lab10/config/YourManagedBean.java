package edu.iit.sat.itmd4515.ryang27lab10.config;

/**
 * @author Wang.Kone
 * @date 2023/11/18 18:56
 */

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;

@ManagedBean
@RequestScoped
public class YourManagedBean {

    @Inject
    private SecurityContext securityContext;

    // Getter and setter for securityContext

    // Your bean methods
}

