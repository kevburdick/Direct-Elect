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
   static MessageProxyComp msgProxy; 
   static MgmtComp mgmtComp;
   
   static public MgmtComp getReference() {return mgmtComp;};
   
   public MgmtComp(DataBaseProxyComp pDatabase) {
       
       logger = Logger.getLogger(MgmtComp.class.getName());
       logger.warn("MgmtComp()");
       
       database = pDatabase;
       //FIXME this will need to handle incoming  requests
       //readMessage();  
       mgmtComp = this;
   }
   
   
   public void processMsg(RequestAccess msg)
   {
       Request request=null;
       logger.debug("readMessage() request access");   
       request = new Request(Request.e_getPassWord);
       request.setUserName(msg.getName()); 
       //FIXME the message needs to be fixed
       request.setRole(Request.r_Admin);
       //update to return response
       if(!database.SendRequest(request))
           //return false;
       if(request.getPassword()==msg.getPasssword())
       {
           Ack rmsg = new Ack();
           rmsg.setMsgId(msg.msgId);
           msgProxy.sendResponse(rmsg);   
       }
       else
       {
          // Nack rmsg = new Ack();
         //  rmsg.setMsgId(msg.msgId);
         //  sendResponse(rmsg);
       }    
   }
   
   
   public void processMsg(Ballot msg)
   {
       Request request=null;
       logger.debug("readMessage() create ballot");   
   /*    request = new Request(Request.e_getPassWord);
       request.setUserName(msg.getName()); 
       //FIXME the message needs to be fixed
       request.setRole(Request.r_Admin);
       if(!database.SendRequest(request))
           return false;
       return true;
       
   */    
  /*     logger.debug("readMessage() create ballot");   
               request = new Request(Request.e_createBallot);
               request.addCandidate("John doe", address, "Senator", "R"); 
               break;
  */     
       
   }
           
   
   public boolean readMessage(RequestMsg msg)
   {
       int type=4;
       Request request=null;
       String address = "8 Pepperell Road Leominster Mass";
       logger.debug("readMessage() "+msg.get().getClass().getSimpleName());    
       
       if(msg.get().getClass().getSimpleName().matches("RequestAccess")) {
            logger.debug("readMessage() request access");   
            RequestAccess access = (RequestAccess) msg.get();
               request = new Request(Request.e_getPassWord);
               request.setUserName(access.getName()); 
               request.setRole(Request.r_Admin);
               if(!database.SendRequest(request))
                    return false;
               return true;   
               //Need to compare the passwords
       }
       else if(msg.get().getClass().getSimpleName().matches("RequestAccess")){
           logger.debug("readMessage() create ballot");   
       }
           
       /*
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
           * 
      */
       return true;
   }
    
  
    
}
