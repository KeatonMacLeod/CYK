
public class Node {
	private String id;
	private String sets;
	private Node next;
	
	public Node (String nodeId, String setVariables)
	{
		id = nodeId;
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
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node nextNode)
	{
		next=nextNode;
	}
}
