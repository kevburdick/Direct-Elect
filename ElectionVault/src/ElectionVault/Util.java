/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ElectionVault;
import  sun.audio.*;
import java.io.*;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
/**
 *
 * @author Kevin
 */
public class Util 
{
    public static final String DATE_TIME_FORMAT_NOW = "HH:mm:ss MM/dd/yy";
    public static final String DATE_FORMAT_NOW = "MM/dd/yy";
    public static final String TIME_FORMAT_NOW = "HH:mm:ss";
    public static boolean ALARM_SOUND_ACTIVE;
    public static String PORT_NAME;
       
    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_NOW);
        return sdf.format(cal.getTime());
   }
    
   public static String date() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
   } 
    public static String time() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_NOW);
        return sdf.format(cal.getTime());
   } 
   
}


