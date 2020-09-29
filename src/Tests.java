import java.util.ArrayList;

public class Tests{
	  // PROJECT 1 UNIT TEST 1	
		void p1runUnit1(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen){
			
			System.out.println("\nPitches:\n");
			pitchGen.print();
			
				
			System.out.println("Rhythms:\n");
			rhythmGen.print();
			
		}
		
	  //PROJECT 1 UNIT TEST 2
		void p1runUnit2(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen) {
			System.out.println(" Generated Pitches: ");
			System.out.println(pitchGen.generate(20));
		
			System.out.println("\nGenerated Rhythms: ");
			System.out.println(rhythmGen.generate(20));
		}
		
		
		//PROJECT 1 UNIT TEST 3
		void p1runUnit3(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen) 
		{
			//creating Probability Generators to train on generated melodies
			ProbabilityGenerator<Integer> pitchTrainer = new ProbabilityGenerator<Integer>();
			ProbabilityGenerator<Double> rhythmTrainer = new ProbabilityGenerator<Double>();
			
			for(int i = 0 ; i < 10000 ; i++) 
			{
				//creating ArrayLists to store generated melodies
				ArrayList<Integer> newSongPitch = new ArrayList<Integer>();
				ArrayList<Double> newSongRhythm = new ArrayList<Double>();
				
				newSongPitch = pitchGen.generate(20);//generating 20 pitch melodies
				pitchTrainer.train(newSongPitch);//training on those^ melodies
				
				newSongRhythm = rhythmGen.generate(20);//generating 20 rhythm melodies
				rhythmTrainer.train(newSongRhythm);//training on those^ melodies
				
			}
				
			p1runUnit1(pitchTrainer, rhythmTrainer);//printing probability distributions
		}
		
		
		//PROJECT 2 UNIT TEST 1
		void p2runUnit1(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen) {
			
		}
		
}
