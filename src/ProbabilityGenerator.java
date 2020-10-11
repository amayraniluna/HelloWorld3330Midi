import java.util.ArrayList;

//Amayrani Luna 
//09/05/20
//Description: This class takes in midi notes and uses them to train the probability generator 
//and uses those notes to generate a new melody in real-time. This is also a parent class for MarkovGenerator

public class ProbabilityGenerator<T> {
//class variables
	ArrayList<T> alphabet;//stores unique tokens
	ArrayList<Integer> alphabet_counts;//stores (in the corresponding alphabet index location) how many times a token appears in the input 
	ArrayList<Double> probDistributions;// stores the normalized probability distributions of each token
	double inputTokCount = 0.0;
	
//class functions
	ProbabilityGenerator()
	{
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();
		probDistributions = new ArrayList<Double>();
	}
	
	
	//returns the ArrayList of probDistributions
	ArrayList<Double> getProbDistributions()
	{
		return probDistributions;
	}
	
	
	//normalizes and sets the probDistributions array
	void normalize() {
		probDistributions.clear();
	 	for(int i = 0 ; i < alphabet_counts.size() ; i++) //calculating probability distributions
		{
			double probability;
			probability = ((alphabet_counts.get(i)).floatValue()) / inputTokCount;
			probDistributions.add(probability);
		}
	}
	
	
  //it is training probability generator with midi notes "newTokens"
	void train(ArrayList<T> newTokens)
	{
		int index;
	   //filling in alphabet + alphabet_count list
		for(int i = 0 ; i < newTokens.size() ; i++) 
		{
	        inputTokCount++;
			index = alphabet.indexOf(newTokens.get(i));
			if(index == -1)//if token not found in alphabet add token to alphabet 
			{
				index = alphabet.size();
				alphabet.add(newTokens.get(i));
				alphabet_counts.add(0);
			}
			
			alphabet_counts.set(index, (alphabet_counts.get(index)) + 1);
		}
		
		normalize();
	 }
	
	
	
	//printing the probability distribution of the tokens
	void print() 
	{
		System.out.println("-----Probability Distribution-----");
		System.out.println();

		for(int i = 0 ; i < probDistributions.size(); i++)
		{
			System.out.println("Token: " + alphabet.get(i) + " | " + "Probability: " + probDistributions.get(i));
		}
		System.out.println("----------");
		System.out.println();
	}
	
	
	
	
	//generating a token 
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
	
	
	
	//generating a melody with "length" amount of tokens using new tokens from generate()
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
