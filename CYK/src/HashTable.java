public class HashTable {
	
	public static final int TABLE_SIZE = 89;
	public static final int HORNER_VAL = 13;
	private int size;
	private LinkedList[] table;
	
	public HashTable () {
		size = TABLE_SIZE;
		table = new LinkedList[size];
		for (int i = 0; i < size; i++)
		{
			table[i] = new LinkedList();
		}
	}
	
	public LinkedList[] getTable()
	{
		return table;
	}
	
	public int hashkey (String s)
	{
		int hashkey = 0;
			for (int i = 0; i < s.length(); i++)
			{
				hashkey = (int)((hashkey + (s.charAt(i) * Math.pow(HORNER_VAL, s.length()-i)))%TABLE_SIZE);
			}
		return hashkey;	
	}
	
	public void insert (String key, String data)
	{
		int index = hashkey(key);
		table[index].add(data);
	}
	
	//Searches the entire table
	public boolean search (String s)
	{
		boolean found = false;
		LinkedList curr;
			for (int i = 0; i < size && !found; i++)
			{
				curr = table[i];
				if (curr.search(s))
				{
					found = true;
				}
			}
		return found;
	}
	
	//Searches at the particular table index
	public boolean searchAtIndex (String key, String data)
	{
		boolean found = false;
		int index = hashkey(key);
			LinkedList curr = table[index];
			if (curr.search(data))
			{
				found = true;
			}
		return found;
	}
	
	//Gets all returns a string of all the variables that can be
	//used in order to generate the terminal in the string.
	public String variablesThatGenerateTerminal (String terminal)
	{
		String variables = "";
		int index = hashkey(terminal);
		LinkedList list = table[index];
		Node curr = list.getTop();
			while (curr != null)
			{
				variables += curr.getData();
				curr = curr.getNext();
			}
		return variables;
	}
	
	
	
	public void print ()
	{
		LinkedList curr;
		for (int i = 0; i < size; i++)
		{
			curr = table[i];
			curr.print();
		}
	}
}