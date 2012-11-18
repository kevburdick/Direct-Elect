/*
 * This is the Vote Component and will manage the votes for current elections 
 * Elections.
 */

package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class VoteComp {

   static Logger logger;
    
   
   public VoteComp() {
       
       logger = Logger.getLogger(VoteComp.class.getName());
       logger.warn("VoteComp()");
       
       //FIXME this will need to handle vote requests
       
   }
  
    
}
