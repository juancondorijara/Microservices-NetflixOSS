package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
@EnableEurekaServer
@SpringBootApplication
@RestController
public class Eureka {

    @RequestMapping("/")
    public String home() {
        return "Hello Server Eureka";
    }

    public static void main(String[] args) {
        SpringApplication.run(Eureka.class, args);
        System.out.println("Server Eureka");
    }

}
