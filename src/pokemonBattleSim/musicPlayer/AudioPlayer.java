package pokemonBattleSim.musicPlayer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.*;

/**
 * This is an example program that demonstrates how to play back an audio file
 * using the SourceDataLine in Java Sound API.
 * @author www.codejava.net
 *
 */
public class AudioPlayer {
public static int stopper;
public static int prevSong;
public static int musicBool;
    // size of the byte buffer used to read/write the audio stream
    private static final int BUFFER_SIZE = 4096;
     
    /**
     * Play a given audio file.
     * @param audioFilePath Path of the audio file.
     */
    public void play(URL audioFilePath) {
    	//audioFilePath = audioFilePath.toLowerCase();
    	System.err.println(audioFilePath);
        //File audioFile = new File(audioFilePath);
        try {
        	stopper = 0;
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFilePath);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
            audioLine.open(format);
            audioLine.start();       
            System.out.println("Playback started.");
            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) 
            {
                audioLine.write(bytesBuffer, 0, bytesRead);
                if (stopper == 1)
                	break;
            }
            audioLine.drain();
            audioLine.close();
            audioStream.close();
            System.out.println("Playback completed.");
            Thread.currentThread().interrupt();
            return;
        }
        
        catch (UnsupportedAudioFileException ex) 
        {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        }
        
        catch (LineUnavailableException ex) 
        {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } 
        
        catch (IOException ex)
        {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }      
    }
     
    public static void main(String[] args) 
    {
        /*Random ran = new Random(); 
        int songID = ran.nextInt(12);
        String audioFilePath;
        if(songID == 0)		//battle view music random selection
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/DiamondAndPearlCyrusBattleCut.wav";
        else if (songID == 1)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/HoennBattleFrontierBrain.wav";
        else if (songID == 2)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/HoennWeatherTrioV2Cut.wav";
        else if (songID == 3)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/MtPyreSummit.wav";
        else if (songID == 4)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/MysteryDungeonAegisCave.wav";
        else if (songID == 5)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/MysteryDungeonHiddenHighland.wav";
        else if (songID == 6)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/ShoalCaveV2.wav";
        else if (songID == 7)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/SilphCo.wav";
        else if (songID == 8)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/TeamMagmaAndAquaBossBattleV2.wav";
        else if (songID == 9)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/TeamPlasma.wav";
        else if (songID == 10)
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/XAndYWildBattleCut.wav";
        else //songID is 11
        	audioFilePath = "/pokemonBattleSim/resources/soundtrack/XAndYSnowbelleCity.wav";
        */
        
        //Menu song
        //audioFilePath = "/pokemonBattleSim/resources/soundtrack/JohtoRoute47.wav";
        
        //Team Builder song
        //audioFilePath = "/pokemonBattleSim/resources/soundtrack/XAndYAnistarCity.wav";
                
        //play the selected song
        /*AudioPlayer player = new AudioPlayer();
        player.play(audioFilePath);*/
    }
 
}