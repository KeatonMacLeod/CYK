public class Node {
	
	private String data;
	private Node next;
	
	public Node (String d)
	{
		data = d;
	}
	
	public String getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node nextNode)
	{
		next=nextNode;
	}
}
