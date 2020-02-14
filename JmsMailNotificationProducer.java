import java.net.URI;
import java.net.URISyntaxException;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class JmsMailNotificationProducer {
    public static void main(String[] args) throws URISyntaxException, Exception {
        //BrokerService broker = BrokerFactory.createBroker(new URI(
        //        "broker:(tcp://localhost:61616)"));
        //broker.start();
        Connection connection = null;
        try {
            // Connection Factory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://localhost:61616");

            //create connection
            connection = connectionFactory.createConnection();

            //create session
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            //create queue
            Queue queue = session.createQueue("MailBoxQueue");
            String notification = "There is a new email notification for you ";

            //create message producer
            MessageProducer producer = session.createProducer(queue);

            for (int i = 0; i < 5; i++){
                String payload = notification +i;
                Message msg = session.createTextMessage(payload);
                System.out.println("Sending text: '" + notification + "'");
                producer.send(msg);
            }
            producer.send(session.createTextMessage("END"));
            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
           // broker.stop();
        }
    }

}