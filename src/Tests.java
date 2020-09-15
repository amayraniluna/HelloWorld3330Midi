
public class Tests{
	  //UNIT TEST 1	
		void runUnit1(ProbabilityGenerator<Integer> pitchGen, ProbabilityGenerator<Double> rhythmGen){
			System.out.println("\nPitches:\n");
			pitchGen.print();
			
			System.out.println("Rhythms:\n");
			rhythmGen.print();
		}	

}
