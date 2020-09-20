import java.util.ArrayList;

public class Tests{
	  //UNIT TEST 1	
		void runUnit1(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen){
			System.out.println("\nPitches:\n");
			pitchGen.print();
			
			System.out.println("Rhythms:\n");
			rhythmGen.print();
		}
		
	  //UNIT TEST 2
		void runUnit2(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen) {
			System.out.println(" Generated Pitches: ");
			System.out.println(pitchGen.generate(20));
		
			System.out.println("\nGenerated Rhythms: ");
			System.out.println(rhythmGen.generate(20));
		}
		
		void runUnit3(MidiFileToNotes song) 
		{
			//Pitch ProbGenerators
			ProbabilityGenerator<Integer> pitchProbDistGen = new ProbabilityGenerator<Integer>();
			ProbabilityGenerator<Integer> pitchGen = new ProbabilityGenerator<Integer>();
			pitchGen.train(song.getPitchArray());
			
			//Rhythm probGenerators 
			ProbabilityGenerator<Double> rhythmProbDistGen = new ProbabilityGenerator<Double>();
			ProbabilityGenerator<Double> rhythmGen = new ProbabilityGenerator<Double>();
			rhythmGen.train(song.getRhythmArray());
			
			
			for(int i = 0 ; i < 10000 ; i++)
			{
				//creating ArrayLists to store generated melodies
				ArrayList<Integer> newSongPitches = new ArrayList<Integer>();
				ArrayList<Double> newSongRhythms = new ArrayList<Double>();
				
				newSongPitches = pitchGen.generate(20);//generating 20 pitch notes
				pitchProbDistGen.train(newSongPitches);//training on those^ 20 notes
				
				newSongRhythms = rhythmGen.generate(20);//generating 20 rhythm notes
				rhythmProbDistGen.train(newSongRhythms);//training on those^ 20 notes 
			}
			
			//printing prob distributions
			runUnit1(pitchProbDistGen, rhythmProbDistGen);
			
			
		}

}
