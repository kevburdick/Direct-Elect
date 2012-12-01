/*
 * This is the MessageProxyComp Component and will handle the conection to the 
 * outside network. It will marshal messages and forward them to the components
 */

package ElectionVault;

import java.io.File;
import java.io.FileInputStream;

import javax.jms.*;
import org.apache.log4j.Logger;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
    
public class MessageProxyComp {

   static Logger logger;
   static MgmtComp mgmtComp; 
   
   public MessageProxyComp(MgmtComp pMgmtComp) {
       
       logger = Logger.getLogger(MessageProxyComp.class.getName());
       logger.warn("MessageProxy()");
       
       
       mgmtComp = pMgmtComp;
     
       //TestMessage();
       JAXBContextResolver test = new JAXBContextResolver();
       
     //  processMsg("");
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

processMsg(m.getText());        
        
         
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
   
   public void processMsg(String msg)
   {
       logger.debug("processMsg()");  
       
       try{
       
            JAXBContext jc = JAXBContext.newInstance( "src/NewXmlSchema.xsd" );
            Unmarshaller unmarshaller = jc.createUnmarshaller();           
            JAXBElement j = (JAXBElement) unmarshaller.unmarshal(
                        new FileInputStream("src/NewXmlSchema.xsd"));
            StringReader reader = new StringReader(msg);
            RequestAccess req = (RequestAccess) j.getValue();     
       } catch (Exception ex) {
            logger.debug("Error: to convert message");
            ex.printStackTrace();
        }
        //test code
               
   }
   public void sendResponse(Ack msg)
   {
       logger.debug("sendResponse()");  
   }
   
   private void TestMessage()
   {
       try {
           
           JAXBContext jc = JAXBContext.newInstance( "src/NewXmlSchema.xsd" );
           Unmarshaller unmarshaller = jc.createUnmarshaller();           
           JAXBElement j = (JAXBElement) unmarshaller.unmarshal(
                        new FileInputStream("src/NewXmlSchema.xsd"));
           RequestAccess req = (RequestAccess) j.getValue();
       } catch (Exception ex) {
            System.out.println("Error: unable to connect to message broker");
            ex.printStackTrace();
       }  
   }
}
