package com.musicPlayer.service;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
/*Author: Tirtha Sharma
 * Email: tirthagenze121@gmail.com
 * MobileNumber: 7001528120
 * Experience : 7 months
 * Technical Skills: JAVA, Hibernate, Spring
*/

public class MyFinalAudioPlayer {
 
    // size of the byte buffer used to read/write the audio stream
    private static final int BUFFER_SIZE = 4096;
    File ff= new File("D:/Downloads/Songs/WAV");
    String listOfSongs[]=ff.list();
    String vv[]= RandomizeStringArray(listOfSongs);
  
    void play() {
    
    	for(String bb:vv){
        	File audioFile = new File("D:/Downloads/Songs/WAV/"+bb);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);          
            audioLine.open(format);
            audioLine.start();    
            System.out.println("Music playback started:::"+bb );
            /* Scanner scan=new Scanner(System.in);
            int c=scan.nextInt();
           if(c==2){
            audioLine.stop();
            }*/
            
            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
                audioLine.write(bytesBuffer, 0, bytesRead);
            }             
            audioLine.drain();
            audioLine.close();
            audioStream.close();            
            System.out.println("Music playback completed:::"+bb);       
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }    catch (Exception ex) {
            ex.printStackTrace();
        }      
    }
  }
   void stop(){
	   
   }
    
   void playPrevious(){
	   
   }
   void playNext(){
	   
   }
    
    
    
    
    
    public static void main(String[] args) {
    	MyFinalAudioPlayer player = new MyFinalAudioPlayer();
    	System.out.println("To start the music Player: Press 1.");
    	System.out.println("For Stopping the music Player: Press 2.");
    	System.out.println("To play the previous music: Press 3.");
    	System.out.println("To play the Next music: Press 4.");
    	
    	Scanner scan= new Scanner(System.in);
    	System.out.println("Please Enter your choice");
    	int choiceSelected=scan.nextInt();
    	
    	switch(choiceSelected){
    	
    	case 1:  player.play();
    	break;
    	case 2:  player.stop();
    	break;
    	case 3:  player.playPrevious();
    	break;
    	case 4:  player.playNext();
    	break;
    	
    	}   
    }
    
    
    public static String [] RandomizeStringArray(String[] array){
    	Random rgen = new Random();  // Random number generator			
    	for (int i=0; i<array.length; i++) {
    	    int randomPosition = rgen.nextInt(array.length);
    	    String temp = array[i];
    	    array[i] = array[randomPosition];
    	    array[randomPosition] = temp;
    	}
    	return array;
    }
 
 
}