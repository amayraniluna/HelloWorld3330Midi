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
			ProbabilityGenerator<Integer> pitchProbDistGen = new ProbabilityGenerator<Integer>();
			ProbabilityGenerator<Integer> pitchGen = new ProbabilityGenerator<Integer>();
			pitchGen.train(song.getPitchArray());
			
			for(int i = 0 ; i < 10000 ; i++)
			{
				//generating 20 notes
				ArrayList<Integer> newSongPitches = new ArrayList<Integer>();
				newSongPitches = pitchGen.generate(20);
				pitchProbDistGen.train(newSongPitches);		
			}
			System.out.println("Pitches: ");
			pitchProbDistGen.print();
		}

}
