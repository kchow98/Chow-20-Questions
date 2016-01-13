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
	Creates a String Representation of the Binary Tree
	*/
	public String toString()
	{
		String tree = "";
		if(left == null || right == null)
		{
			tree += value;
		}

		else if(left !=null)
		{
			tree += left.toString();
		}
		else
		{
			tree += right.toString();
		}
		
		tree +=  "\n";

		return tree;
	}
	
	/**
	Return true if adding a node to tree would increase its height
	@return boolean whether or not the tree is full
	*/
	
	/**
	Returns the maximum path length to a descendent	
	@return int the height of the s
	*/
	public int height()
	{
		if (isLeaf() == true)
		1+ thing below it.
-if leaf return 0 (base case)
-if not a leaf, return 1+maximum of height left and right (math.max
	
	}
	public boolean isFull()
	{
	-if leaf, return true (base case)
-if either left or right is null - false
-return left is full and right is full and 
		
	}





}

/**







Modifiers:
public void setLeft(BinaryTree<E> node)
public void setRight(BinaryTree<E> node)
public void setValue(E val)

//Return true if node does not have any children (if left and right is null)
public boolean isLeaf()

//Return number of descendants of node, including current node
public int size()

Iterators:
public Iterator<E> iterator()
public Iterator<E> preorderIterator()
{
	-Root
	-Left
	-Right
}
public Iterator<E> inorderIterator()
{
	-Left
	-Root
	-Right
}
public Iterator<E> postorderIterator()
{
	-Left
	-Right
	-Root
}

public String toString()



//Return true if adding a node to tree would increase its height
public boolean isFull()
-if leaf, return true (base case)
-

//Return true if tree has minimal height(no two leaves have a difference of one?
 and any holes in the tree //appear in the last level to the right
public boolean isComplete()
-if leaf, is true
if left is null, return false
if right is null, check if left is a leaf. (if so, true)

-fheck if left hieght-right height  = 1
-	if left is complete 
	-if right is full right is full.
-if heights of left and right are equal, 
	-left full 
	right complete?
//Return true if the difference of heights of subtrees at every node //is no greater than one
public boolean isBalanced()// check each level's heights from the bottom, then make sure there is no difference more than 1
-if leaf return true (base case)
-if right is null, left has to be a leaf, and vice versa
-return left and right differences are -1

*/