/**
This is a LinkedListIterator class. This allows the linkedlists created by LinkedLinked
class to be iterated.

@author Kevin Chow
@version 11.23.15
*/
import java.util.NoSuchElementException;
import java.util.Iterator;
public class LinkedListIterator<E> implements Iterator<E>
{
	private ListNode<E> curr;
	
	
	/**
	Constructor of LinkedList Iterator
	@param head the first thing in the LinkedList
	*/	
	public LinkedListIterator(ListNode<E> head)
	{
		curr = head;
	}
	
	/**
	Returns true if the iteration has more elements.
	@return boolean true if there is a next item, false if there is not
	*/
	public boolean hasNext()
	{
		return (curr!= null);
	}
	
	/**
	Returns the next element in the iteration. 
	Throws the NoSuchElementException - if the iteration has no more elements
	@return E next element in the iteration
	*/
	public E next()
	{
		if (hasNext() == false)
			throw new NoSuchElementException();
		E item = curr.getItem();
		curr = curr.getNext();
		return item;
	}
	
	/**
	Removes from the underlying collection the last element returned by this 
	iterator (optional operation). 
	Not actually defined.
	*/
	public void remove()
	{
	}
	
}