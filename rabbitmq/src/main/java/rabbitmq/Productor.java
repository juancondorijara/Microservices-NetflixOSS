package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

public class Productor {

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("Hola Productor");
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare("hello-world", false, false, false, null);

            String mensaje1 = "Mensaje desde Productor 1 " + LocalDateTime.now();
            String mensaje2 = "Mensaje desde Productor 2 " + LocalDateTime.now();

            channel.basicPublish("", "hello-world", false, null, mensaje1.getBytes());
            channel.basicPublish("", "hello-world", false, null, mensaje2.getBytes());
            System.out.println("Mensaje enviado");
        }
    }

}
