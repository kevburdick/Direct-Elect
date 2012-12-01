/*
 * This is the Database Proxy and will manage the java requests from other 
 * components and interface with the postgres database 
 */
package ElectionVault;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.jms.*;
import java.sql.Connection;
import org.apache.log4j.Logger;

    
public class DataBaseProxyComp {

   static Logger logger;
   private Connection connection;
   
   public DataBaseProxyComp() {
       
       logger = Logger.getLogger(DataBaseProxyComp.class.getName());
       logger.warn("DataBaseProxyComp()");
       
       //FIXME this will need to handle incoming requests and handle the sql
       
   }
   public void DataBaseConnection() {
       
                try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
		connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/directelect", "kernelklink",
					"password");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
   
   boolean SendRequest(Request req)
        {
            logger.debug("SendRequest"+req.getType());
            return true;   
          
        }
        
       
            
  
    
}
