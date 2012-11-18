/*
 * This is the Database Proxy and will manage the java requests from other 
 * components and interface with the postgres database 
 */
package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class DataBaseProxyComp {

   static Logger logger;
    
   
   public DataBaseProxyComp() {
       
       logger = Logger.getLogger(DataBaseProxyComp.class.getName());
       logger.warn("DataBaseProxyComp()");
       
       //FIXME this will need to handle incoming  requests and handle the sql
       
   }
  
    
}
