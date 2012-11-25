/*
 * This is the main class to intitialize the ElectionVault
 */

package ElectionVault;

//import javax.jms.*;
import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
    
public class ElectionVault {

   static Logger logger;
   static String ELECTVAULT_VERSION = "0.0.0.1";
   static final String LOG_PROPERTIES_FILE = "log4j.properties";
   static int FILE_PROPERTIES_LENGTH = 256;
   static String DB_HOST="localhost";
        
   public static void main(String[] args) {
        //start a logger
        logger = Logger.getLogger(ElectionVault.class.getName());
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        
        //load configuration file
        logger.warn("ElectVault version:"+ELECTVAULT_VERSION);
        String propFile = "electVault.properties";
        File handle = new File(propFile);
        if(handle.exists()) {
            String text = getFileData(handle);
            getFileProp(text);
        }
        else {
            logger.warn("FileNotFound: "+propFile);
        }
        
        //once the logger is up and configuration file loaded initialize the 
        //components
        new MediaComp();
        new MgmtComp();
        new VoteComp();
        new DataBaseProxyComp();
        //MessageProxy should be last component initalized so nothing can in 
        //until everything is up
        new MessageProxyComp();
        
        
    }
    
    /*
     * This method opens the configuration file 
     */
    static String getFileData(File pFile)
    {
        byte temp[] = new byte[FILE_PROPERTIES_LENGTH];
        FileInputStream inStream;
        try {
            inStream= new FileInputStream(pFile);
            inStream.read(temp, 0, FILE_PROPERTIES_LENGTH);
        }
        catch (FileNotFoundException e){
        }
        catch (IOException e){
        }  
        String test = new String(temp);
        return test; 
    }
    
    
    /*
     * The method reads for a configuration file for parameters
     * order of the file must match the order of  this method
     * FIXME this method need to be more robust
    */
    static void getFileProp(String properties)
    {
        String datakey="", equalSign="", value="", result="";
        String pAppTimeDelay="";
        String pCommTimeDelay="";
        
        StringTokenizer tokens =  new StringTokenizer(properties);
          
        //= Integer.parseInt(value); 
        //=Boolean.parseBoolean(value); 
        
        datakey = tokens.nextToken();
        equalSign = tokens.nextToken();
        value = tokens.nextToken();
        Util.PORT_NAME=value; 
        //System.out.println("PORT_NAME:"+Util.PORT_NAME);
        logger.warn("PORT_NAME:"+Util.PORT_NAME);
        
         //Database Host    
        datakey = tokens.nextToken();
        equalSign = tokens.nextToken();
        value = tokens.nextToken();  
        DB_HOST = value;
        logger.warn("DB_HOST:"+DB_HOST);
        
    }

}
