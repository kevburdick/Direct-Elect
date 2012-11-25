/*
 * This is the MessageProxyComp Component and will handle the conection to the 
 * outside network. It will marshal messages and forward them to the components
 */

package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class MessageProxyComp {

   static Logger logger;
    
   
   public MessageProxyComp() {
       
       logger = Logger.getLogger(MessageProxyComp.class.getName());
       logger.warn("MessageProxy()");
       
       //FIXME: this needs to be a new thread, uncomment to recieve message
       //This will block on message queue and hold the entire app right now
       //EstablishConnection();
       
   }
   //This establishes a queue and waits for a message
   //FIXME: this meeds to be a new thread and refactored into methods and classes 
   //and not hang system on input
   public boolean EstablishConnection() {
      try {
         // creating a connection factory
         // we are cheating here by not using jdni
         ConnectionFactory cf= new com.sun.messaging.ConnectionFactory();

         // create a connection
         //FIXME this should be in the config file 
         //people will to edit this for their specific machine and setup
         Connection connection = cf.createConnection("user","cs575");
        
         // create a session
         Session session = connection.createSession( 
               false , Session.AUTO_ACKNOWLEDGE);

         // create destination HelloWorld
         Destination destination = session.createQueue("Election1");

         // create a consumer
         MessageConsumer consumer = session.createConsumer(destination);

         // now that everything is ready to go, start the connection
         connection.start();

         // receive our message
         TextMessage m = (TextMessage)consumer.receive();

         System.out.println(m.getText());

         // close everything
         consumer.close();
         session.close();
         connection.close();

        } catch (JMSException ex) {
            System.out.println("Error: unable to connect to message broker");
            ex.printStackTrace();
        }
      return true;
    }
   
    
}
