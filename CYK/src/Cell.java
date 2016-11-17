public class Cell {
	
	private String id;
	private String sets;
	
	public Cell (String identification, String setVariables)
	{
		id = identification;
		sets = setVariables;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getSets()
	{
		return sets;
	}
	
	public void print()
	{
		String sets = this.getSets();
		System.out.print(this.getId() + "->");
		for (int i = 0; i < sets.length(); i++)
		{
			if (i+1 == sets.length())
			{
				System.out.println(sets.charAt(i));
			}
			else
			{
				System.out.print(sets.charAt(i) + "|");
			}
		}
	}
	
}
