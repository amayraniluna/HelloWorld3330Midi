import java.util.ArrayList;

public class MarkovGenerator<T> extends ProbabilityGenerator<T> {
//class variables
	ArrayList<ArrayList<Integer>> transitionTable;
	ProbabilityGenerator<T> initTokGenerator = new ProbabilityGenerator<T>();
	

//class functions
	MarkovGenerator()
	{
		super();//Inheriting from parent class
		transitionTable = new ArrayList();
	}
	
	
	
	//creating the transition table from midi notes "input"
	void train(ArrayList<T> input)
	{	
		initTokGenerator.train(input);

		int lastIndex = -1;
		int tokenIndex;
	 
		for(int i = 0 ; i < input.size() ; i++)//iterating through input array 
		{
			tokenIndex = alphabet.indexOf(input.get(i));//looking for input token in alphabet array
		    //if token is not found in alphabet
		 	if(tokenIndex == -1)  
			{
				tokenIndex = alphabet.size();
			    //adding new row of with "0" values to transition table
				ArrayList<Integer> newRow = new ArrayList<Integer>(alphabet.size());
				for(int a = 0 ; a < alphabet.size() ; a++)
				{
					newRow.add(0);
				}
				transitionTable.add(newRow);
				
			    //adding a 0 to the end of all the arrays 
				for(int x = 0 ; x < transitionTable.size(); x++) 
				{
					ArrayList<Integer> row = new ArrayList<Integer>();
					row = transitionTable.get(x);
					row.add(0);				
				}	
					
				alphabet.add(input.get(i));//adding token to alphabet array
			}
			
		    //Adding counts to transition table if not the first iteration	
			if(lastIndex > -1)
			{		
				//adding 1 to the value of (lastIndex, tokenIndex)
				ArrayList<Integer> row = new ArrayList<Integer>();
				row = transitionTable.get(lastIndex);
				int myElement = row.get(tokenIndex);
				myElement+=1;
				row.set(tokenIndex, myElement);
			}
			lastIndex = tokenIndex; //setting current to previous for next round 
		}
		System.out.print("alphabet: " + alphabet);
		generate(64);
	}
	
	
	
	//3rd
	T generate(T initToken)
	{
		int initTokIndex = alphabet.indexOf(initToken);//getting index of initToken in alphabet
		ArrayList<Integer> TTrow = transitionTable.get(initTokIndex);//getting counts of that token from TransitionTable
		alphabet_counts = TTrow;//setting global variable alphabet_counts to TTrow
		normalize();//global variable probDistributions[] made from TTrow
		
		System.out.print("normalized array: " + probDistributions);
		
		//if sum of the row = 0 call probGenerate.generate (mk sure to train)
		//else
		//set probDistributions = to normalized transTable row 
		//then call super.generate
		
		T newToken = null;
		return newToken;
	}
	
	
	
	//2nd
	ArrayList<T> generate(T initToken, int numOfTokensToGenerate)
	{
		ArrayList<T> newSequence = new ArrayList<T>();
			for(int i = 0 ;i < numOfTokensToGenerate ; i++)
			{
				T newToken = generate(initToken);
				newSequence.add(newToken);
				initToken = newToken;
			}
			return newSequence;
	}
	
	
	
	//1st
	//generating a melody with "numOfTokensToGenerate" amount of tokens
	ArrayList<T> generate(int numOfTokensToGenerate)
	{
		//using an instance of your ProbabilityGenerator class to generate initToken
		T randomInitTok = initTokGenerator.generate();
		//System.out.println("random Token: " + randomInitTok);
		return generate(randomInitTok, numOfTokensToGenerate);
		
	}
	
	
	//printing the transition table of tokens 
	void tablePrint() 
	{
		System.out.println("-----Transition Table-----");
		System.out.println("    " +  alphabet);
		
		for(int i = 0 ; i < transitionTable.size() ; i++) 
		{
			System.out.println(alphabet.get(i) + "  " + transitionTable.get(i));
		}
	}
}
