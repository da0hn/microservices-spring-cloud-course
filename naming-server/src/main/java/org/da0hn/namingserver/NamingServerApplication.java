package org.da0hn.namingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingServerApplication {

  public static void main(final String[] args) {
    SpringApplication.run(NamingServerApplication.class, args);
  }

}
