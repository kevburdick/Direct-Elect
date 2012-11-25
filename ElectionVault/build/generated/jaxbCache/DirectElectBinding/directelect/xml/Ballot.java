//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.24 at 02:15:31 PM EST 
//


package directelect.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ballot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ballot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msg_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="election_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="candidate_fname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="candidate_lname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="party" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ballot", propOrder = {
    "msgId",
    "electionId",
    "candidateFname",
    "candidateLname",
    "position",
    "party"
})
public class Ballot {

    @XmlElement(name = "msg_id")
    protected int msgId;
    @XmlElement(name = "election_id")
    protected int electionId;
    @XmlElement(name = "candidate_fname", required = true)
    protected String candidateFname;
    @XmlElement(name = "candidate_lname", required = true)
    protected String candidateLname;
    @XmlElement(required = true)
    protected String position;
    @XmlElement(required = true)
    protected String party;

    /**
     * Gets the value of the msgId property.
     * 
     */
    public int getMsgId() {
        return msgId;
    }

    /**
     * Sets the value of the msgId property.
     * 
     */
    public void setMsgId(int value) {
        this.msgId = value;
    }

    /**
     * Gets the value of the electionId property.
     * 
     */
    public int getElectionId() {
        return electionId;
    }

    /**
     * Sets the value of the electionId property.
     * 
     */
    public void setElectionId(int value) {
        this.electionId = value;
    }

    /**
     * Gets the value of the candidateFname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCandidateFname() {
        return candidateFname;
    }

    /**
     * Sets the value of the candidateFname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCandidateFname(String value) {
        this.candidateFname = value;
    }

    /**
     * Gets the value of the candidateLname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCandidateLname() {
        return candidateLname;
    }

    /**
     * Sets the value of the candidateLname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCandidateLname(String value) {
        this.candidateLname = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the party property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParty() {
        return party;
    }

    /**
     * Sets the value of the party property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParty(String value) {
        this.party = value;
    }

}
