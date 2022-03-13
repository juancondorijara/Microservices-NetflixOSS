package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumidor {

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("Hola Consumidor");
        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("hello-world",false,false, false, null);
        channel.basicConsume("hello-world",true, (consumidorTag, mensaje) -> {
            String recibir = new String(mensaje.getBody(), "UTF-8");
            System.out.println("Mensaje recibido = " + recibir);
        }, consumidorTag -> {});
    }

}
