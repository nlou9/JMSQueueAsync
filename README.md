## 
This program is to implement a simple JMS Queue which can be useful for the notification mailbox. It applies asynchronous
message receive.
### 
The broker is started as a server listening on port 61616.
The JMS Clients willing to connect to the broker will be using the TCP protocol (tcp://localhost:61616).
The producer would send 5 notifications.
The consumer would consume the messages asynchronously.
all the code would run on local machine, so it would use localhost.

#### GET STARTED
#### HOW TO RUN:
1. Open a console, run BrokerLauncher
   java -jar BrokerLauncher.jar
2. Open the second console, run Producer
   java -jar JmsMailNotificationProducer.jar
3. Open the third console, run JmsMessageListenerConsumer
   java -jar JmsMessageListenerConsumer.jar

4. Results:  
   1） When lauching broker, the broker is started as a server listening on port 61616.  
   The JMS Clients willing to connect to the broker will be using the TCP protocol (tcp://localhost:61616).    
   Log:
   INFO | Listening for connections at: tcp://localhost:61616  
   INFO | Connector tcp://localhost:61616 started  

   2） When run producer side code, producer would generate five information in loop.  
   It sends message ‘END’ to indicate the client that it has sent the last message.  
   Log:  
   Sending text: 'There is a new email notification for you '  
   Sending text: 'There is a new email notification for you '  
   Sending text: 'There is a new email notification for you '  
   Sending text: 'There is a new email notification for you '  
   Sending text: 'There is a new email notification for you '  

   3）When run consumer side code, consumer would receive message asynchronously via Message Listener.  
   Log:  
   Customer received There is a new email notification for you 0  
   Customer received There is a new email notification for you 1  
   Customer received There is a new email notification for you 2  
   Customer received There is a new email notification for you 3  
   Customer received There is a new email notification for you 4  
   Customer received END  
