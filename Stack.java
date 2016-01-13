/**
This is a my Stack interface. LIFO (Last in first out)

@author Kevin Chow
@version 11.29.15
*/
public interface Stack<E>
{
	/**
	Add object to the top of the stack
	@param E item that is being added to the stack
	*/
	void push(E item);
	
	/**
	Remove top  object from stack
	@return top item in the stack
	*/
	E pop();
	
	/**
	Returns, but does not remove, the top item 
	@return E top item
	*/
	E peek(); 
	
	/**
	Return whether or not the Stack is empty
	@return boolean whether or not the Stack is empty
	*/
	boolean isEmpty(); 
	
}

