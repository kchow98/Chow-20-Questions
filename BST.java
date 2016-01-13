public class BST <E extends Comparable>
{

	private BinaryTree<E> root;
	
	public BST(E v)
	{
		root = new BinaryTree<E>(v);
	}
	
	/**
	Return false if already in there (no dupilicates), returns true if added
	*/
	public boolean add(E v)
	{
		return add(v, root)
	}
	
	public boolean add(E v, BinaryTree<E> root)
	{
		if(v.equals(root.value()))
		{
			return false;
		}
		
		if(v.compareTo(root.value()) < 0)
		{
			if(root.left() ==  null())
			{
				BinaryTree<E> newTree = new BinaryTree<E>(v);
				root.setLeft(newTree);
				return true;
			}
			
			return add(v, root.left());

		}
		
		if(v.compareTo(root.value()) > 0)
		{
			if(root.right() ==  null())
			{
				BinaryTree<E> newTree = new BinaryTree<E>(v);
				root.setRight(newTree);
				return true;
			}
			return add(v, root.right());
		}
		
				
	}
	/**
	Goes through and finds the object, including all the pointers that is connected
	*/
	public BinaryTree<E> find(E v)
	{
	}
	
	/** Optional
	public boolean remove(E v)
	{
	}
	*/
	
	public String toString()
	{
		return root.toString();
	}

	public static void main(String[] args)
	{
		
	}
	
	
}
