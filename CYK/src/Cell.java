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
	
	public String getSetString()
	{
		String result = "{";
		
			for (int i = 0; i < sets.length(); i++)
			{
				if (i+1 == sets.length())
				{
					result += sets.charAt(i);
				}
				else
				{
					result += sets.charAt(i) + ",";
				}
			}
			
		result += "}";
		return result;
	}
	
	public void print()
	{
		String sets = this.getSets();
		System.out.print(this.getId() + "->");
		for (int i = 0; i < sets.length(); i++)
		{
			if (i+1 == sets.length())
			{
				System.out.print(sets.charAt(i));
			}
			else
			{
				System.out.print(sets.charAt(i) + "|");
			}
		}
	}
	
}
