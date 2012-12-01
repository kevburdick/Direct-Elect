/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectionVault;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author RjDavis
 */
public class JAXBContextResolver {
    
    public JAXBContextResolver(){
        try {
            JAXBContext jc = JAXBContext.newInstance("directelect.xml");
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Create Domain Objects
            Election election1 = new Election();
            election1.setElectionId(1);
            election1.setMsgId(1);
            
            Vote vote1 = new Vote();
            vote1.setCandidateFname("Barack");
            vote1.setCandidateLname("Obama");
            vote1.setElectionId(1);
            vote1.setMsgId(1);
            vote1.setParty("Democrat");
            vote1.setPosition("President");
            
            EligibleVoter eligibleVoter1 = new EligibleVoter();
            eligibleVoter1.setCity("Philadelphia");
            eligibleVoter1.setFname("John");
            eligibleVoter1.setLname("Doe");
            eligibleVoter1.setMsgId(1);
            eligibleVoter1.setPassword("password");
            eligibleVoter1.setState("PA");
            eligibleVoter1.setStreet("6355 Lancaster Ave, Apt 201");
            eligibleVoter1.setVoterId(1);

            File file = new File("src/vote1.xml");
            
            // Marshal
            marshaller.marshal(election1, System.out);
            marshaller.marshal(election1, file);
            marshaller.marshal(vote1, System.out);
            marshaller.marshal(eligibleVoter1, System.out);
        
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBContextResolver.class.getName()).log(Level.SEVERE, "Failed to instantiate JAXBContext.", ex);
        }   
    }
}
