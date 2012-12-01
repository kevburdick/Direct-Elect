/*
 * This is the Vote Component and will manage the votes for current elections 
 * Elections.
 */

package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class VoteComp {

   static Logger logger;
   static DataBaseProxyComp database; 
   static MessageProxyComp msgProxy; 
   static VoteComp voteComp;
   
   static public VoteComp getReference() {return voteComp;}; 
   
   public VoteComp(DataBaseProxyComp pDatabase) {
       
       logger = Logger.getLogger(VoteComp.class.getName());
       logger.warn("VoteComp()");
       
       database = pDatabase;
       //FIXME this will need to handle incoming  requests
       //readMessage();  
       voteComp = this;
       
   }
  
    
}
