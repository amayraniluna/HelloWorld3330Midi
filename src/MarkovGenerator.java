import java.util.ArrayList;

public class MarkovGenerator<T> extends ProbabilityGenerator<T> {
	//class variables
	ArrayList<ArrayList<Integer>> transitionTable;
	
	//class functions
	MarkovGenerator()
	{
		super();
		transitionTable = new ArrayList<>();
	}
	
	T generate()
	{
		T newToken = null;
		//do something here
		return newToken;
	}
	
	void train(ArrayList<T> input)
	{
		int lastIndex = -1;
	 
		for(int i = 0 ; i < input.size() ; i++)//iterating through input array 
		{
			int tokenIndex = alphabet.indexOf(input.get(i));//looking for input token in alphabet array
			
			if(tokenIndex == -1) //if token is not found in alphabet 
			{
				tokenIndex = alphabet.size();
				
				//adding new row to transition table
				ArrayList<Integer> myRow = new ArrayList<Integer>(alphabet.size());
				transitionTable.add(myRow);
				
				//Adding a 0 to all of the arrays 
				for(int x = 0 ; x < transitionTable.size(); x++) {
					ArrayList<Integer> row = transitionTable.get(x);
					row.add(0);
				}
				
				//adding token to alphabet array
				alphabet.add(input.get(i));
			}
			
		    //adding counts to transition table 	
			if(lastIndex == -1)// if not the first iteration 
			{
				//adding 1 to the value of (lastIndex, tokenIndex)
				ArrayList<Integer> row = transitionTable.get(lastIndex);
				int myElement = row.get(tokenIndex);
				myElement++;
				row.set(tokenIndex, myElement);
			}
			
			lastIndex = tokenIndex; //setting current to previous for next round 
		}
		
	}
	
	ArrayList<T> generate(int length)
	{
		ArrayList<T> newSequence = new ArrayList<T>();
	//	for(int i = 0 ;i < length ; i++)
	//	{
	//		newSequence.add(generate());
	//	}
		return newSequence;
	}
	
	ArrayList<T> generate(int length, T initToken)
	{
		ArrayList<T> newSequence = new ArrayList<T>();
		//	for(int i = 0 ;i < length ; i++)
		//	{
		//		newSequence.add(generate());
		//	}
			return newSequence;
	}
}
