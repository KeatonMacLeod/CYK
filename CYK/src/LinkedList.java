
public class LinkedList {
	private Node top;
	
	public LinkedList ()
	{
		top = null;
	}
	
	public void add (Node newNode)
	{
		newNode.setNext(top);
		top = newNode;
	}
	
	public Node returnNull()
	{
		return null;
	}
	
	public void print ()
	{
		Node curr = top;
		while (curr != null)
		{
			System.out.println("id: " + curr.getId() + " | Sets:" + curr.getSets());
			curr = curr.getNext();
		}
	}
}