/**
This is a my Queue interface. FIFO (First in first out)

@author Kevin Chow
@version 11.29.15
*/
public interface Queue<E>
{
	/**
	Add object to the end of the queue
	@param E item that is being added to the queue
	*/
	void offer(E Item);
	
	/**
	Remove first object from queue
	@return first item in the queue
	*/
	E poll();
	
	/**
	Returns, but does not remove, the head item 
	@return E head item
	*/
	E peek();
	
	/**
	Return whether or not the Queue is empty
	@return boolean whether or not the Queue is empty
	*/
	boolean isEmpty();
}

	