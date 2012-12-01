/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectionVault;
import org.apache.log4j.Logger;


import java.util.*;
/**
 *
 * @author kevin
 */
public class Request {
    
    static Logger logger;
    
    //Request type
    public static final int e_invalid =0;
    public static final int e_getPassWord =1;
    public static final int e_createBallot =2;
    public static final int e_requestVoterCriteria =3;
    public static final int e_forwardVoterCriteria =4;
    public static final int e_max =5;
 
    //Role
    public static final int r_invalid =0;
    public static final int r_Voter =1;
    public static final int r_Admin =2;
    
    private 
    int type = e_invalid;
    int electionID =0;
    String user ="";
    String password ="";
    int role = r_invalid; 
    
    Vector  candList;//candidate list
    Vector  locationList;//candidate location list
    Vector  positionList;//candidate position list
    Vector  partyList;//candidate party list
    Vector  criteriaList;//criteria list
    
    public int getType()
    {
        return type;
    }
    
            
    public Request(int pType)
    {
        if(pType >  e_invalid && pType < e_max) {
            type = pType;
        }
        else {
            
            logger.warn("Request() invalid Request type"+pType);   
            type = e_invalid;
        }
            
        candList=new Vector<String>();
        locationList = new Vector<String>();//candidate location list
        positionList = new Vector<String>();//candidate position list
        partyList= new Vector<String>();//candidate party list
         criteriaList= new Vector<String>();//criteria list
    }
    
    /*
     *  User name has to be first name and last name and be tokenized
     *  This is used for a getPassword Request
     */
    public boolean setUserName(String pUser)
    {
        user = pUser;
        return true;
    }
    
    public String getPassword()
    {
        return password;
    }
    /*
     *  This is used for a createBallot Request
     *  
     */
    public boolean setElectionID(int pId)
    {
        electionID = pId;
        return true;
    }
    
    /*
     *  Candidate has to be first name and last name and be tokenized
     *  Location has to be Street, City, State and be tokenized
     *  This is used for a createBallot Request
     */
    public boolean addCandidate(String pCand, String pLoc, String pPos, String pParty)
    {
        candList.add(pCand);
        locationList.add(pLoc);//candidate location list
        positionList.add(pPos);//candidate position list
        partyList.add(pParty);//candidate party list
        return true;
    }        
       
    /*
     *  This is used for a createBallot Request
     */
    public boolean setRole(int pRole)
    {
        if(pRole == r_Voter || pRole == r_Admin)
            role = pRole;
        else {
            logger.warn("setRole() invalid role"+pRole);   
            return false;
        }
        return true;
    }  
    
    public boolean addCriteria(String pCrit)
    {
        criteriaList.add(pCrit);
        return true;
    }
    
            
}


