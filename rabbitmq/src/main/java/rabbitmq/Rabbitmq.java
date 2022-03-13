package rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
//@EnableEurekaServer
@SpringBootApplication
@RestController
public class Rabbitmq {

    @RequestMapping("/")
    public String home() {
        return "Hello Client RabbitMQ";
    }

    public static void main(String[] args) {
        SpringApplication.run(Rabbitmq.class, args);
        System.out.println("Client RabbitMQ");
    }

}
