

/*
 * c2017-2019 Courtney Brown 
 * 
 * Class: H
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer
 * 
 */

import processing.core.*;

import java.util.*; 

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

			//make sure this class name matches your file name, if not fix.
public class HelloWorldMidiMain3330 extends PApplet {

	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file

	//create generator for pitch and rhythm
	ProbabilityGenerator<Integer> pitchGenerator = new ProbabilityGenerator<Integer>();
	ProbabilityGenerator<Double> rhythmGenerator = new ProbabilityGenerator<Double>();
	MarkovGenerator<Integer> markovPitchGenerator = new MarkovGenerator<Integer>();
	MarkovGenerator<Double> markovRhythmGenerator = new MarkovGenerator<Double>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("HelloWorldMidiMain3330"); //change this to match above class & file name 

	}

	//setting the window size to 300x300
	public void settings() {
		size(300, 300);

	}

	//doing all the setup stuff
	public void setup() {
		fill(120, 50, 240);
		
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		playMidiFile(filePath);

		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.


//		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);
		
	
		//training
		pitchGenerator.train(midiNotes.getPitchArray());
		rhythmGenerator.train(midiNotes.getRhythmArray());
		markovPitchGenerator.train(midiNotes.getPitchArray());
		markovRhythmGenerator.train(midiNotes.getRhythmArray());
		
	
		player = new MelodyPlayer(this, 100.0f);
		player.setup();
		//player.setMelody( pitchGenerator.generate(20) );
		//player.setRhythm( rhythmGenerator.generate(20) );
	}

	public void draw() {
		player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset
		
		textSize(12);
		fill(0, 102, 153);
		text("Press 1 to print probability distributions", width/13, height/6);
		text("Press 2 to generate random melodies", width/13, height/3);
		text("Press 3 to generate 10,000 random melodies", width/13, height/2);
		text("Press 4 to print transition table", width/13, 2*height/3);
	}

	//this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
	   Tests myTest = new Tests();
	   MidiFileToNotes midiNotesMary; //reads a midi file
	   String filePath = getPath("mid/MaryHadALittleLamb.mid");//returns a url
	   midiNotesMary = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
															//be created with "new". Note how every object is a pointer or reference. Every. single. one.
	
		midiNotesMary.setWhichLine(0);// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
				
		if (key == ' ') {
			player.reset();
			println("Melody started!");
		}
		else if(key == '1') {
			myTest.p1runUnit1(pitchGenerator, rhythmGenerator);
			player.play();

		}
		else if(key == '2') {
			myTest.p1runUnit2(pitchGenerator, rhythmGenerator);
		}
		else if(key == '3') {
			myTest.p1runUnit3(pitchGenerator, rhythmGenerator);
		}
		else if(key == '4') {
			myTest.p2runUnit1(markovPitchGenerator, markovRhythmGenerator);
		}
	}
}

