public class Run {
	
	public static void main (String[] args)
	{
		checkInput();
	}
	
	static void checkInput ()
	{
		//Our grammar: 
		//S -> AB | BC
		//A -> BA | a
		//B -> CC | b
		//C -> AB | a
		HashTable table = new HashTable();
		table.insert("AB", "C");
		table.insert("AB", "S");
		table.insert("BC", "S");
		table.insert("BA", "A");
		table.insert("a", "C");
		table.insert("a", "A");
		table.insert("CC", "B");
		table.insert("b", "B");

		
		String input = "baaba";
		Cell[][] array = new Cell[input.length()][input.length()];
		initializeRowZero(table, array, input);
		fillTable(table,array,input);
		printArray(array);
	}
	
	static void initializeRowZero (HashTable table, Cell[][] array, String input)
	{
		String letter;
		String sets;
		
		for (int i = 0; i < input.length(); i++)
		{
			letter = "" + input.charAt(i);
			sets = table.generatingVariables(letter);
			Cell letterCell = new Cell (letter, sets);
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
				String variableSet = fillCellData(table, array, cellId);
				array[r][c] = new Cell(cellId, variableSet);
			}
	}
	
	static String fillCellData(HashTable table, Cell[][]array, String cellId)
	{
		String one;
		String two;
		String set = "";
		String setVariables = "";
		for (int i = 0; i < cellId.length()-1; i++)
		{
			System.out.println(cellId);

			one = cellId.substring(0,i+1);
			two = cellId.substring(i+1,cellId.length());
			System.out.println(one + "|" + two);
			String setOne = findCellSets(table, array, one);
			String setTwo = findCellSets(table, array, two);
			set = combineSets(table, array, cellId, setOne, setTwo);
			setVariables += set;
		}
		removeDuplicates(setVariables);
	return setVariables;
	}
	
	static String findCellSets (HashTable table, Cell[][]array, String cellId)
	{
		String sets = "";
		boolean found = false;
		int r = cellId.length()-1; //The row the cellId is in.
			for (int c = 0; c < array.length-r && !found; c++)
			{
				if (array[r][c] != null && (array[r][c].getId()).equals(cellId))
				{
					sets = array[r][c].getSets();
				}
			}
		return sets;
	}
	
	static String combineSets (HashTable table, Cell[][]array, String cellId, String setOne, String setTwo)
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
					System.out.println("Combined:" + combined);
					String variable = checkSet(table, array, combined);
					variableSet += variable;
				}
			}
			System.out.println("VAR SET:" + variableSet);
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
	
	static String checkSet (HashTable table, Cell[][]array, String combined)
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
	
	static void printArray(Cell[][] array)
	{
		for (int r = 0; r < array.length; r++)
			for (int c = 0; c < array.length; c++)
			{
				if (array[r][c] != null)
				{
					System.out.print("[Row " + r + "][Col " + c + "] ");
					array[r][c].print();
				}
			}
	}
}
