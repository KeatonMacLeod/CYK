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
		table.insert("AB", "S");
		table.insert("BC", "S");
		table.insert("BA", "A");
		table.insert("a", "A");
		table.insert("CC", "B");
		table.insert("b", "B");
		table.insert("AB", "C");
		table.insert("a", "C");
		
		String input = "baaba";
		Cell[][] array = new Cell[input.length()][input.length()];
		initializeRowZero(table, array, input);
	}
	
	static void initializeRowZero (HashTable table, Cell[][] array, String input)
	{
		String letter;
		String sets;
		
		for (int i = 0; i < input.length(); i++)
		{
			letter = "" + input.charAt(i);
			System.out.println(letter);
			sets = table.generatingVariables(letter);
			Cell letterCell = new Cell (letter, sets);
			array[0][i] = letterCell;
		}
	}



}
