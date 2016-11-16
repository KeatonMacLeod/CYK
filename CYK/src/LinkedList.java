public class LinkedList {
	
	private Node top;
	
	public LinkedList ()
	{
		top = null;
	}
	
	public Node getTop()
	{
		return top;
	}
	
	public void add (String s)
	{
		Node newNode = new Node(s);
		newNode.setNext(top);
		top = newNode;
	}
	
	public boolean search (String s)
	{
		boolean found = false;
		Node curr = top;
			while (curr != null && !found)
			{
				if (curr.getData().equals(s))
				{
					found = true;
				}
				curr = curr.getNext();
			}
		return found;
	}
	
	public void print ()
	{
		Node curr = top;
		while (curr != null)
		{
			System.out.println(curr.getData());
			curr = curr.getNext();
		}
	}
}