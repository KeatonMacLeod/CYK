
public class Run {
	
	public static void main (String[] args)
	{
		
		HashTable table = new HashTable();
		table.insert("AB", "S");
		table.insert("a", "A");
		table.insert("a", "C");
		table.print();
		System.out.println(table.searchAtIndex("a","A"));
		System.out.println(table.searchAtIndex("a","B"));
	}

}
