import java.util.ArrayList;

public class MarkovGenerator<T> extends ProbabilityGenerator<T> {
	//class variables
	ArrayList<ArrayList<Integer>> transitionTable = new ArrayList();
	
	//class functions
	MarkovGenerator()
	{
		super();
	}
	
	
	void train(ArrayList<T> input)
	{
		int lastIndex = -1;
	 
		for(int i = 0 ; i < input.size() ; i++)//iterating through input array 
		{
			int tokenIndex = alphabet.indexOf(input.get(i));//looking for input token in alphabet array
			
		  //If token is not found in alphabet
			if(tokenIndex == -1)  
			{
				tokenIndex = alphabet.size();
				
				//adding new row of with "0" values to transition table
				ArrayList<Integer> myRow = new ArrayList<Integer>(alphabet.size());
				for(int a = 0 ; a < myRow.size() ; a++) 
					myRow.set(a,0);
				
				transitionTable.add(myRow);
				
				//Adding a 0 to the end of all the arrays 
				for(int x = 0 ; x < transitionTable.size(); x++) 
				{
					ArrayList<Integer> tempRow = transitionTable.get(x);
					tempRow.add(0);
				}
				
				//adding token to alphabet array
				alphabet.add(input.get(i));
			}
			
		 //Adding counts to transition table 	
			if(lastIndex > -1)// if not the first iteration 
			{		
				//adding 1 to the value of (lastIndex, tokenIndex)
				ArrayList<Integer> row = transitionTable.get(lastIndex);
				int myElement = row.get(tokenIndex);
				myElement++;
				row.set(tokenIndex, myElement);
			}
			
			lastIndex = tokenIndex; //setting current to previous for next round 
		}
		
		//calculating probability distributions 
		//for transitionTable[i]
		//{
		 //for row[i]
		 //{
		 //	 add the 
	}
	
	
	T generate()
	{
		T newToken = null;
		//do something here
		return newToken;
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
