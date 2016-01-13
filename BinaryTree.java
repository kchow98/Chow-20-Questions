import java.lang.Math;
import java.lang.Iterable;
import java.util.Iterator;
/**
A Binary Tree is a data structure in which each node points to two other nodes, referred 
to as its left child and its right child.

Notes:
 do full, do balance (use -1 to represent balance., then use full and balance to complete

@author Kevin Chow
@version 12.9.15
*/
public class BinaryTree<E>
{
	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;
	
	
	/**
	Default Constructor. Value, left, and right are all null
	*/
	public BinaryTree()
	{
		value = null;
		left = null;
		right = null;
	}

	/**
	Set value equal to v, left and right are null
	@param E v the value of the Binary Tree
	*/
	public BinaryTree(E v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	/**
	Set value to v, left to l, right to r.
	@param E v the value of the Binary Tree
	@param BinaryTree<E> l the value of the left pointer
	@param BinaryTree<E> r the value of the right pointer
	*/
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
	Accessor method for the value
	@return E the value of the Binary Tree
	*/
	public E value()
	{
		return value;
	}
	
	/**
	Accessor method for left pointer.
	@return BinaryTree<E> the binary tree the left pointer points to.
	*/
	public BinaryTree<E> left()
	{
		return left;
	}
	
	/**
	Accessor method for right pointer.
	@return BinaryTree<E> the binary tree the right pointer points to.
	*/
	public BinaryTree<E> right()
	{
		return right;
	}
	
	/**
	Modifier for the left pointer
	@param BinaryTree<E> node the new tree to point to
	*/
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	
	/**
	Modifier for the right pointer
	@param BinaryTree<E> node the new tree to point to
	*/
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	
	/**
	Modifier for the value
	@param E val the value to set to
	*/
	public void setValue(E val)
	{
		value = val;
	}
	
	/**
	Returns if the binary tree is a leaf or not, which is when there are no children
	@return boolean whether or not the node has any children
	*/
	public boolean isLeaf()
	{
		return (left == null && right == null);
	}
	
	/**
	Returns the number of descendants of node, including the current node
	@return int number of descendants
	*/
	public int size()
	{
		if(isLeaf())
		{
			return 1;
		}
		else if(left == null)
		{
			return 1 + right.size();
		}
		else if(right == null)
		{
			return 1 + left.size();
		}
		else
		{
		return 1 + left.size() + right.size();		
		}
	}
	
	/**
	Return the maximum path length to a descendent
	@return int the height of a node
	*/
	public int height()
	{
		if(isLeaf())
		{
			return 1;
		}
		
		else if(left == null)
		{
			return right.height() + 1;
		}
		
		else if(right() == null)
		{
			return left.height() + 1;
		}

		else
		{
			return Math.max(left.height(), right.height()) + 1;
		}
	}
	
	/**
	Creates a String Representation of the Binary Tree
	@return String string representation of the Binary Tree
	*/
	public String toString()
	{
		String s = "";
		if(isLeaf() == true)
		{
			s += value;
			return s;
		}
		else if(left == null)
		{
			s += value + "[";
			s += "[_]";
			s += "[";
			s += right.toString();
			s += "]";

		}
		else if(right == null)
		{
			s += value + "[";
			s += "[";
			s += left.toString();
			s += "]";
			s += "[_]";
			s += "]";

		}
		
		else
		{
			s += value;
			s += "[";
			s += left.toString();
			s += "]";
			s += "[";
			s += right.toString();
			s += "]";
		
		}
		return s;
	}
	
	/**
	Return true if adding a node to tree would increase its height
	@return boolean whether or not adding a node to tree would increase height
	*/
	public boolean isFull()
	{
		if(isLeaf())
		{
			return true;
		}
		
		else if(left == null)
		{
			return false;
		}
		else if(right == null)
		{
			return false;
		}
		
		else
		{
			if(left.height() == right.height())
			{
				return left.isFull() && right.isFull();
			}
			else 
			{
				return false;
			}
		
		
		}
	}

	/**
	Return true if tree has minimal height
	@return boolean whether or not the tree has minimal height
	*/
	public boolean isComplete()
	{
		if(isLeaf())
		{
			return true;
		}
		
		else if(left == null)
		{
			return false;
		} 
		
		else if (right == null)
		{
			if (left.isLeaf())
			{
				return true;
			}
			return false;
		}
		
		else
		{
			if(left.height()-right.height() == 1)
			{
				if (left.isComplete())
				{
					if(right.isFull())
					{
						return true;
					}
				}
			}
			
			else if(left.height() == right.height())
			{
				if(left.isFull())
				{
					if(right.isComplete())
					{
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	/**
	Return true if the difference of heights of subtrees at every node is no greater 
	than one,
	@return boolean whether or not difference of heights of subtrees are no greater than 1
	*/
	public boolean isBalanced()
	{
		if(isLeaf())
		{
			return true;
		}
		
		else if(left == null)
		{
			if(right.isLeaf())
			{
				return true;
			}
		}
		
		else if(right == null)
		{
			if(left.isLeaf())
			{
				return true;
			}
		}
		
		else if(Math.abs(left.height()-right.height()) <= 1)
		{
			return left.isBalanced() && right.isBalanced();
		}
		
		return false;
	}
	
	/**
	Create and return an iterator (pre order) of LinkedList
	@return Iterator<E> an iterable (pre order) version of LinkedList
	*/
	public Iterator<E> PreOrderIterator()
	{
		return new PreOrderIterator<E>(this);
	}
	
	/**
	Create and return an iterator (In order) of LinkedList
	@return Iterator<E> an iterable  (In order)  version of LinkedList
	*/
	public Iterator<E> InOrderIterator()
	{
		return new InOrderIterator<E>(this);
	}
	
	/**
	Create and return an iterator (post order) of LinkedList
	@return Iterator<E> an iterable (post order) version of LinkedList
	*/
	public Iterator<E> PostOrderIterator()
	{
		return new PostOrderIterator<E>(this);
	}
	
	/**
	Create and return an iterator (in order) of LinkedList
	@return Iterator<E> an iterable (in order) version of LinkedList
	*/
	public Iterator<E> Iterator()
	{
		return new InOrderIterator<E>(this);
	}
}

