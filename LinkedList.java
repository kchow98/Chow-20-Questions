/**
This is a my LinkedList class. 
A linked list is a data structure consisting of a group of nodes which together represent
a sequence. Each node contains a piece of data and a pointer to the next node in the 
sequence.  This structure allows for efficient insertion or removal of elements from 
any position in the sequence. My implementation is a singly-linked list with a 
head and tail pointer.

@author Kevin Chow
@version 11.29.15
*/
import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedList<E> implements Iterable<E>, Stack<E>, Queue<E>
{
	//First item in the LinkedList
	private ListNode<E> head;
	
	//points to last node in list
	private ListNode<E> tail;
	
	//number of nodes in list
	private int size;
	
	/**
	Default constructor. Creates an empty LinkedList.
	Sets head and tail to null just for good coding practice. Size is set to 0.
	*/
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	Constructor that takes in a starting ListNode for a new LinkedList
	Precondition: h.getNext() == null
	@param ListNode<E> h is the starting node in the new linked list.
	*/
	public LinkedList(ListNode<E> h)
	{
		head = h;
		tail = h;
		size = 1;
	}
	
	/**
	Copy constructor
	@param LinkedList<E> other LinkedList being copied
	*/
	public LinkedList(LinkedList<E> other)
	{
		if (other.size() == 0)
			throw new IllegalArgumentException();
			
		ListNode<E> newHead = new ListNode<E>(other.getHead().getItem());	
		head = newHead;
		
		ListNode<E> currinNewList = head;
		for(ListNode<E> curr = other.getHead().getNext(); curr!= null; curr = curr.getNext())
		{
			ListNode<E> newNode = new ListNode<E>(curr.getItem());	
			currinNewList.setNext(newNode);
			currinNewList = newNode;

		}	
		tail = currinNewList;
		size = other.size();
	}

	/**
	Return the number of nodes in the LinkedList
	@return int number of nodes in the LinkedList
	*/
	public int size()
	{
		return size;
	}
	
	/**
	Returns head. Helper Method.
	@return ListNode<E> the head of the LinkedList
	*/
	private ListNode<E> getHead()
	{
		return head;
	}
	
	/**
	Returns tail. Helper Method.
	@return ListNode<E> the tail of the LinkedList
	*/
	private ListNode<E> getTail()
	{
		return tail;
	}
	
	/**
	Adds node to end of the LinkedList.
	@param E toAdd node to add
	@return boolean whether the ListNode was added.
	*/
	public boolean add(E toAdd)
	{
		add(size, toAdd);
		return true;
	}
	
	/**
	Add item to the specified spot and shift the other items down
	@param int index what spot to add item at
	@param E toAdd item to add 
	@return boolean whether the ListNode was added.
	*/
	public boolean add(int index, E toAdd)
	{
		if (index<0 || index > size) //index can be equal to size. If thats the case, 
		//you're just adding to end of list. (probably called using other add method).
			throw new IndexOutOfBoundsException();
			
		ListNode<E> newNode = new ListNode<E>(toAdd);
		
		if (index == 0)
		{
			if (size == 0)
			{
				head = newNode;
				tail = newNode; //has to to set the tail if nothing in list yet
				size++;
			}	
			else 
			{
				newNode.setNext(head); //sets the new node to point to the previously 1st
				head = newNode;
				size++;
			}	
			return true;
		}
		if (index == size) //less runtime than traversing all the way through
						   //if you want to add to last spot in the list
		{
			tail.setNext(newNode);
			tail = newNode;
			size++;
			return true;
		}
		
		int counter = 0;
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if(counter == index-1) // -1 because you need to stop at the node before
								   //the spot you want to add your item
			{
				newNode.setNext(curr.getNext());
				curr.setNext(newNode);
				size++;
				
				return true;
			}
			counter++;
		}
		return false;
	}
	
	/**
	Add object to front of list
	@param E toAdd item to add 
	*/
	public void addFirst(E toAdd)
	{
		add(0,toAdd);
	}

	/**
	Add object to end of list
	@param E toAdd item to add 
	*/
	public void addLast(E toAdd)
	{
		add(size,toAdd);
	}
	
	/**
	Removes the first instance of specified object 
	@param E obj the first instance of this object will be removed.
	@return boolean if object was removed
	*/	
	public boolean remove(E obj)
	{
		if (size == 1) // because the loop below doesn't work if size > 1
		{
			if (head.getItem().equals(obj))
			{
				head = null;
				tail = null;
				size--;
				return true;
			}
		}
		for(ListNode<E> curr = head; curr!= null; curr = curr.getNext())
		{
			ListNode<E> nextNode = curr.getNext(); 
			if (nextNode.getItem().equals(obj))
			{
				if (tail == nextNode)//because if is last node, will need to reset tail
				{
					tail = curr;
				}
				curr.setNext(nextNode.getNext());//would set curr's next to null if 
												 //removing last item in list
				size--;
				return true;
			}
		}
		return false;

	}
	
	/**
	Removes and returns the item at a specified index. Returns null if nothing is removed
	@param int index the spot of item you want to remove
	@return E item you are removing
	*/
	public E remove(int index)
	{
		if (index<0 || index >= size) //less than or equal because you can't remove 
		//something at the size index cuz nothing would be there.
			throw new IndexOutOfBoundsException();		
		if (index == 0)
		{
			ListNode<E> removed = head;

			if (size == 1)
			{
				head = null;
				tail = null;
				size--;
			}	
			else 
			{
				head = removed.getNext();
				size--;				
			}	
			return removed.getItem();
		}
		
		int counter = 0;
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if(counter == index - 1) // -1 because you need to stop at the node before
			{
				ListNode<E> removed = curr.getNext();
				curr.setNext(removed.getNext());
				if (index == size-1) //in case remove last one
				{
					tail = curr;
				}
				size--;

				return removed.getItem();
			}
			counter++;
		}
		return null;
	}

	/**
	Remove and return first item in the list
	@return E item you are removing
	*/
	public E removeFirst()
	{
		if (size == 0)
			throw new NoSuchElementException();
		return remove(0);
	}

	/**
	Remove and return last item in the list
	@return E item you are removing
	*/
	public E removeLast()
	{
		if (size == 0)
			throw new NoSuchElementException();
		return remove(size-1); //it is -1 because index of last item is one less than size
	}
	
	/**
	Return index of the first instance of specified object
	@param E obj object to find index of
	@return int index of object in the list, returns -1 if not in list
	*/
	public int indexOf(E obj)
	{
		int indexOfObj = -1;
		int counter = 0;
		for(ListNode<E> curr = head; curr!= null; curr = curr.getNext())
		{
			if(curr.getItem().equals(obj))
			{
				indexOfObj = counter;
				return indexOfObj;
			}	
			counter++;
		}
		return indexOfObj;		
	}
	
	/**
	Return whether or not the list contains specified object
	@param E obj object to look for in the list
	@return boolean whether not not the item is contained in the list
	*/
	public boolean contains(E obj)
	{
	//Related Methods: indexOf
		if(indexOf(obj) >=0)
			return true;
		return false;
	}
	
	/**
	Remove all items from the list
	*/
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	Return whether or not the list is empty
	@return boolean whether or not the LinkedList is empty
	*/
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		return false;
	}
	
	/**
	Return item at specified index
	@param int index the spot of item you want to get
	@return E item at the index, returns null if nothing
	*/
	public E get(int index)
	{
		if (index<0 || index>size-1)
			throw new IndexOutOfBoundsException();
		int counter = 0;
		for(ListNode<E> curr = head; curr!= null; curr = curr.getNext())
		{
			if (counter == index)
			{
				return curr.getItem();
			}
			counter++;
		}
		return null;
		
	}
	
	/**
	Place object at specified location.
	@param int index place in list to set as specified item
	@param E obj item being set into list
	@return E item being replaced at index, null if nothing
	*/
	@SuppressWarnings("unchecked")
	public E set(int index, E obj)
	{
		if (index<0 || index>size-1)
			throw new IndexOutOfBoundsException();
		int counter = 0;
		for(ListNode<E> curr = head; curr!= null; curr = curr.getNext())
		{
			if(counter == index)
			{
				E itemToBeOverWritten = curr.getItem();
				curr.setItem(obj);
				return itemToBeOverWritten;
			}
			counter++;
		}
		return null;
	}

	/**
	Create and return an iterator of LinkedList
	@return Iterator<E> an iterable version of LinkedList
	*/
	public Iterator<E> iterator()
	{
		return new LinkedListIterator<E>(head);
	}
	
	/**
	How the LinkedList will be displayed once printed
	@return String string visual of LinkedList
	*/
	public String toString()
	{
		String toPrint = "{";
		if (size>0)// if there is something in the linked list.
		{
			for(ListNode<E> curr = head; curr!= null; curr = curr.getNext())
			{
				toPrint += curr.toString();
				toPrint +=", ";
			}
			toPrint = toPrint.substring(0,toPrint.length()-2);
		}
		toPrint +="}";
		return toPrint;
	}
	
	/**
	Add object to the top of the stack
	@param E item that is being added to the stack
	*/
	public void push(E item)
	{
		addFirst(item);
	}
	
	/**
	Remove object from stack
	@return first item in the stack
	*/
	public E pop()
	{
		return removeFirst();
	}

	/**
	Returns, but does not remove, the head item 
	@return E head item
	*/
	public E peek()
	{
		if (head != null)
			return head.getItem();
		return null;
	}

	/**
	Add object to the end of the queue
	@param E item that is being added to the queue
	*/
	public void offer(E item)
	{
		add(item);
	}

	/**
	Remove object from queue
	@return first item in the queue
	*/
	public E poll()
	{
		return removeFirst();
	}
	
	
	
}


















