/*
 * This is the Management Component and will manage things like Creating a 
 * ballot, AccessRequests, etc
 */

package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class MgmtComp {

   static Logger logger;
   static DataBaseProxyComp database; 
   
   public MgmtComp(DataBaseProxyComp pDatabase) {
       
       logger = Logger.getLogger(MgmtComp.class.getName());
       logger.warn("MgmtComp()");
       
       database = pDatabase;
       //FIXME this will need to handle incoming  requests
       //readMessage();  
   }
   
   
   
   public boolean readMessage()
   {
       int type=4;
       //request access = 1
       //create ballot =2
       //request voter criteria =3
       Request request=null;
       String address = "8 Pepperell Road Leominster Mass";
       
       switch(type) {
           case 1: 
               logger.debug("readMessage() request access");   
               request = new Request(Request.e_getPassWord);
               request.setUserName("John doe"); 
               request.setRole(Request.r_Admin);
               //if password response matches message password then 
               //return ack 
               break;
           case 2: 
               logger.debug("readMessage() create ballot");   
               request = new Request(Request.e_createBallot);
               request.addCandidate("John doe", address, "Senator", "R"); 
               break;
           case 3: 
               logger.debug("readMessage() request voter criteria");   
               request = new Request(Request.e_requestVoterCriteria);
               break;
           case 4: 
               logger.debug("readMessage() forward voter criteria");   
               request = new Request(Request.e_forwardVoterCriteria);
               request.addCriteria("location");
               break;
           default:
               logger.debug("readMessage() unknown type");  
               return false;
       }
       if(!database.SendRequest(request))
           return false;
       return true;
   }
    
  
    
}
