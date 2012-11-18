/*
 * This is the Management Component and will manage things like Creating a 
 * ballot, AccessRequests, etc
 */

package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class MgmtComp {

   static Logger logger;
    
   
   public MgmtComp() {
       
       logger = Logger.getLogger(MgmtComp.class.getName());
       logger.warn("MgmtComp()");
       
       //FIXME this will need to handle incoming  requests
       
   }
  
    
}
