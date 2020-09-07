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
		//************************************
		//*******LEFT OFF RIGHT HERE**********
		//************************************
		
		for(int i = 0; i < newTokens.size() ; i++){
			for(int j = 0; j < alphabet.size(); j++){
				
				if((newTokens.get(i)).equals(alphabet.get(j))){
						//adds 1 to alphabet_count
						int newCount = alphabet_counts.get(j) + 1;
						alphabet_counts.set(j, newCount);
				}
					else {
						alphabet.add(newTokens.get(i));
						alphabet_counts.add(1);
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
