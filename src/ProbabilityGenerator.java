import java.util.ArrayList;

//Amayrani Luna 
//09/05/20
//Description: taking in notes to train probability generator and using those notes to generate a new melody in real-time.

public class ProbabilityGenerator<T> {
	
	ArrayList<T> alphabet;
	ArrayList<Integer> alphabet_counts;
	ArrayList<Double> probDistributions;
	double inputTokens = 0.0;
	
	
	ProbabilityGenerator()
	{
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();
		probDistributions = new ArrayList<Double>();
	}
	
	
	ArrayList<Double> getProbDistributions()
	{
		return probDistributions;
	}
	
	
  //it is training probability generator with new data 
	void train(ArrayList<T> newTokens)
	{
		int index;
		
	   //filling in alphabet + alphabet_count list
		for(int i = 0 ; i < newTokens.size() ; i++) 
		{
	        inputTokens++;
			index = alphabet.indexOf(newTokens.get(i));
			
		   //if token not found in alphabet add token to alphabet 
			if(index == -1)
			{
				index = alphabet.size();
				alphabet.add(newTokens.get(i));
				alphabet_counts.add(0);
			}
			
			alphabet_counts.set(index, (alphabet_counts.get(index)) + 1);
		}
		
		probDistributions.clear();
		
	   //calculating probability distributions
	 	for(int i = 0 ; i < alphabet_counts.size() ; i++) 
		{
			double probability;
			probability = ((alphabet_counts.get(i)).floatValue()) / inputTokens;
			probDistributions.add(probability);
		}
	 }
	
	
	
	void print() 
	{
		System.out.println("-----Probability Distribution-----");
		System.out.println();

		for(int i = 0 ; i < probDistributions.size(); i++) {
			System.out.println("Token: " + alphabet.get(i) + " | " + "Probability: " + probDistributions.get(i));
		}
		System.out.println("----------");
		System.out.println();
	}
	
	
	
	
	
	T generate() 
	{
		T newToken = null;
		ArrayList<Double> probDistributionSums = new ArrayList<Double>();
		double sum = probDistributions.get(0);
		
	    //adding the sums of the probabilities
		for(int i = 0; i < probDistributions.size() ; i++) 
		{
			probDistributionSums.add(sum);
		    //adding probability value + next probability value
			if(!(i == probDistributions.size()-1))
				sum += probDistributions.get(i + 1);
		}
		
		float rIndex = (float)Math.random();//generating random number
		 
		//determining newToken from random number
		for(int i = 0 ; i < alphabet.size(); i++)
		{
			if(rIndex <= probDistributionSums.get(i))
			{
				newToken = alphabet.get(i);
				break;
			}
		}
			
		return newToken;
	}
	
	
	
	
	ArrayList<T> generate(int length)
	{
		//generating a melody of size length
		ArrayList<T> newSequence = new ArrayList<T>();
		for(int i = 0 ; i < length ; i++) {
			newSequence.add(generate());
		}
		return newSequence;	
	}
}
