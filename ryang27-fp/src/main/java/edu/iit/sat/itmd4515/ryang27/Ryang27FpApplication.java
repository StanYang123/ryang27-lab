package edu.iit.sat.itmd4515.ryang27;

import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ryang27FpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ryang27FpApplication.class, args);
    }

}
