import java.util.ArrayList;

//Amayrani Luna 
//09/05/20
//Description: ******Fill this out******

public class ProbabilityGenerator<T> {
	
	ArrayList<T> alphabet;
	ArrayList<Integer> alphabet_counts;
	
	
	ProbabilityGenerator(){
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();

	}
	
//it is training probability generator with new data 
	void train(ArrayList<T> newTokens){
		//code the training
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
