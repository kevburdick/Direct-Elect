/*
 * This is the Media Component and will manage the requests for stats on previous 
 * Elections.
 */

package ElectionVault;

import javax.jms.*;
import org.apache.log4j.Logger;
    
public class MediaComp {

   static Logger logger;
    
   
   public MediaComp() {
       
       logger = Logger.getLogger(MediaComp.class.getName());
       logger.warn("MediaComp()");
       
       //FIXME this will need to handle incoming media requests
       
   }
  
    
}
