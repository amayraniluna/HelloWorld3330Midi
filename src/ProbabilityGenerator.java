import java.util.ArrayList;

//Amayrani Luna 
//09/05/20
//Description: taking in notes to train probability generator and using those notes to generate a new melody in real-time.

public class ProbabilityGenerator<T> {
	
	ArrayList<T> alphabet;
	ArrayList<Integer> alphabet_counts;
	ArrayList<Double> probDistributions;
	
	
	ProbabilityGenerator()
	{
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();// <--should I add 1???
		probDistributions = new ArrayList<Double>();

	}
	
//it is training probability generator with new data 
	void train(ArrayList<T> newTokens)
	{
		
	   //filling in alphabet + alphabet_count list
		for(int i = 0; i < newTokens.size() ; i++)
		{
			
			T currToken = newTokens.get(i);	
			if(i == 0) {

				alphabet.add(currToken);
				alphabet_counts.add(1);
				//System.out.println(alphabet.get(0));   		****LEFT OFF RIGHT HERE*****
				//System.out.println(alphabet_counts.get(0));   *** testing to see where ***
				//System.out.println("  ");						****  program reaches  *****
				break;
			}
			for(int j = 0; j < alphabet.size(); j++)
			{
				
				if(currToken.equals(alphabet.get(j)))
				{
					
					//adding alph_counts for repeated tokens
					int newCount = alphabet_counts.get(j) + 1;
					alphabet_counts.set(j, newCount);
					break;
				}
					else 
					{
						if(j == alphabet.size() - 1)
						{
							//adding unique tokens to alphabet
							alphabet.add(currToken);
							alphabet_counts.add(1);
						}
					}
			}
			//testing if alphabet and alphabet_counts were populated
			System.out.print(alphabet.get(i));
			System.out.print(" ");
			System.out.print(alphabet_counts.get(i));
		}
		
		
		//calculating probability distribution
		for(int i = 0 ; i < alphabet.size() ; i++)
		{
			double probability = (alphabet_counts.get(i)) / (alphabet_counts.size());
			probDistributions.add(probability);
		}
		
		
	}
	
	
	T generate() {
		T newToken = null;
		//do something here
		return newToken;
	}
	
	ArrayList<T> generate(int length){
		ArrayList<T> newSequence = new ArrayList<T>();
		for(int i = 0 ; i < length ; i++) {
			newSequence.add(generate());
		}
		return newSequence;	
	}
}
