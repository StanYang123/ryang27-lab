
package edu.iit.sat.itmd4515.ryang27.config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@DataSourceDefinition(
        name = "java:app/jdbc/itmd4515DS",
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        serverName = "127.0.0.1",
        portNumber = 3306,
        databaseName = "itmd4515",
        user = "itmd4515",
        password = "itmd4515",
        properties = {
            "zeroDateTimeBehavior=CONVERT_TO_NULL",
            "useSSL=false"
        }
)
public class Itmd4515DatabaseConfig {
    
}
