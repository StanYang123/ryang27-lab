package edu.iit.sat.itmd4515.ryang27.config;

/**
 * @author Wang.Kone
 * @date 2023/10/5 19:16
 */

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class GlobalConfig {
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> {
            factory.addContextCustomizers((context) -> {
                String relativePath = "ryang27-fp/src/main/webapp";
                File docBaseFile = new File(relativePath);
                if (docBaseFile.exists()) {
                    context.setDocBase(docBaseFile.getAbsolutePath());
                }
            });
        };
    }
}
