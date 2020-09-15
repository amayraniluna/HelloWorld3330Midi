
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

}
