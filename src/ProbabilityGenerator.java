import java.util.ArrayList;

//Amayrani Luna 
//09/05/20
//Description: taking in notes to train probability generator and using those notes to generate a new melody in real-time.

public class ProbabilityGenerator<T> {
	
	ArrayList<T> alphabet;
	ArrayList<Integer> alphabet_counts;
	
	
	ProbabilityGenerator(){
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>(1);

	}
	
//it is training probability generator with new data 
	void train(ArrayList<T> newTokens){
	   //filling in alphabet + alphabet_count list
		for(int i = 0; i < newTokens.size() ; i++){
			T currToken = newTokens.get(i);	
		
			for(int j = 0; j < alphabet.size(); j++){
				if(currToken.equals(alphabet.get(j))){
					//adding alph_counts for repeated tokens
					int newCount = alphabet_counts.get(j) + 1;
					alphabet_counts.set(j, newCount);
					break;
				}
					else {
						if(j == alphabet.size() - 1){
							//adding unique tokens to alphabet
							alphabet.add(currToken);
							alphabet_counts.add(1);
						}
					}
			}
				
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
