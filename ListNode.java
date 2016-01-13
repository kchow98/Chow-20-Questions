/**
This is a my ListNode class. 

Note: API labels the thing in the node as "value", but I had coded this and linked list,
before you released the API, with the name "item" instead. 

@author Kevin Chow
@version 11.15.15
*/
public class ListNode<E>
{
	//item in node
	private E item;
	
	//pointer to next node
	private ListNode<E> next;
	
		
	/**
	Constructor, sets the item and since there is no pointer parameter, sets it to null
	for good coding practice.
	@param E item to be put in the node.
	*/	
	public ListNode(E item)
	{
		this.item = item;
		this.next = null;
	}
	
	/**
	Constructor, sets the item and the next thing (the pointer)
	@param E item to be put in the node.
	@param ListNode<E> next the next thing in the linked list (aka what it points to)
	*/	
	public ListNode(E item, ListNode<E> next)
	{
		this.item = item;
		this.next = next;
	}
	
	/**
	Returns the item in the node.
	@return E item in the node.
	*/	
	public E getItem()
	{
		return item;
	}
	
	/**
	Returns the thing this node points to 
	@return ListNode<E> the thing this node points to
	*/	
	public ListNode<E> getNext()
	{
		return next;
	}
	
	/**
	Sets the item in the node
	@param E item what to set the item to be
	*/
	public void setItem(E item)
	{
	
		this.item = item;
	}
	
	/**
	Sets the next thing (what this node points to)
	@param ListNode<E> next what to set the next thing to (what this node points to)
	*/
	public void setNext(ListNode<E> next)
	{
		this.next = next;
	}
	
	/**
	How the ListNode will be displayed once printed
	@return String string visual of the node.
	*/
	public String toString()
	{
		String stringoflinknode = "[" + item + "]";
		return stringoflinknode;
	}
	
}

