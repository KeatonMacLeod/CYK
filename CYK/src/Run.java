public class Run {
	
	//Performs all of the basic control flow after CYKGUI calls this method.
	static boolean checkInput (HashTable table, String output, String startVariable)
	{
		boolean canBeGenerated = false;
		Cell[][] array = new Cell[output.length()][output.length()];
		initializeRowZero(table,array,output);
		fillTable(table,array,output);
		printArray(array);
		
		if (output.length() > 0)
		{
			Cell check = array[output.length()-1][0];
			String sets = check.getSets();
			if (sets.indexOf(startVariable) > -1)
			canBeGenerated = true;
		}

		
		return canBeGenerated;
	}		 
	
	//Use the output string in order to determine which sets of variables in the CFG
	//can be used to generate the given input string for the first row.
	static void initializeRowZero (HashTable table, Cell[][] array, String input)
	{
		String terminal;
		String sets;
		
		for (int i = 0; i < input.length(); i++)
		{
			terminal = "" + input.charAt(i);
			sets = table.variablesThatGenerateTerminal(terminal);
			Cell letterCell = new Cell (terminal, sets);
			array[0][i] = letterCell;
		}
	}
	
	static void fillTable(HashTable table, Cell[][] array, String input)
	{
		String cellId;
		for (int r = 1; r < input.length(); r++)
			for (int c = 0; c < input.length()-r; c++)
			{
				cellId = input.substring(c, c+(r+1));
				String variableSet = getCellVariableSets(table, array, cellId);
				array[r][c] = new Cell(cellId, variableSet);
			}
	}
	
	static String getCellVariableSets(HashTable table, Cell[][]array, String cellId)
	{
		String one;
		String two;
		String set = "";
		String setVariables = "";
		for (int i = 0; i < cellId.length()-1; i++)
		{
			one = cellId.substring(0,i+1);
			two = cellId.substring(i+1,cellId.length());
			String setOne = getCellIdVariableSet(table, array, one);
			String setTwo = getCellIdVariableSet(table, array, two);
			set = generateVariableSetPermutations(table, array, cellId, setOne, setTwo);
			setVariables += set;
		}
		setVariables = removeDuplicates(setVariables);
	return setVariables;
	}
	
	static String generateVariableSetPermutations (HashTable table, Cell[][]array, String cellId, String setOne, String setTwo)
	{
		String combined;
		String partOne;
		String partTwo;
		String variableSet = "";

			for (int i = 0; i < setOne.length(); i++)
			{
				for (int j = 0; j < setTwo.length(); j++)
				{
					partOne = "" + setOne.charAt(i);
					partTwo = "" + setTwo.charAt(j);
					combined = partOne + partTwo;
					System.out.println("ONE:" + combined);
					String currSet = getCombinedVariableSets(table, array, combined);
					variableSet += currSet;
				}
			}
			
			variableSet = removeDuplicates(variableSet);
			return variableSet;
	}
	
	static String getCombinedVariableSets (HashTable table, Cell[][]array, String combined)
	{
		String sets = "";
		int index = table.hashkey(combined);
		LinkedList list = (table.getTable())[index];
		Node curr = list.getTop();
			while (curr != null)
			{
				sets += curr.getData();
				curr = curr.getNext();
			}
		return sets;
	}
	
	static String getCellIdVariableSet (HashTable table, Cell[][]array, String cellId)
	{
		String variableSet = "";
		boolean found = false;
		int r = cellId.length()-1; //The row the cellId is in.
			for (int c = 0; c < array.length-r && !found; c++)
			{
				if (array[r][c] != null && (array[r][c].getId()).equals(cellId))
				{
					variableSet = array[r][c].getSets();
					found = true;
				}
			}
		return variableSet;
	}
	
	static String removeDuplicates(String input){
	    String result = "";
	    for (int i = 0; i < input.length(); i++) {
	        if(!result.contains(String.valueOf(input.charAt(i)))) {
	            result += String.valueOf(input.charAt(i));
	        }
	    }
	    return result;
	}
	
	static void printArray(Cell[][] array)
	{
		for (int r = 0; r < array.length; r++)
			for (int c = 0; c < array.length; c++)
			{
				if (array[r][c] != null)
				{
					System.out.print("[Row " + r + "][Col " + c + "] ");
					array[r][c].print();
					System.out.println();
				}
			}
	}
}
