/**
This is a my BinaryTree Runner.

@author Kevin Chow
@version 11.29.15
*/
import java.util.Iterator;
public class RunnerBinaryTree
{
	public static void main(String[] args)
	{
		BinaryTree<String> e1 = new BinaryTree<String>("E1");
		BinaryTree<String> e2 = new BinaryTree<String>("E2");


		
		BinaryTree<String> d5 = new BinaryTree<String>("D5");
		BinaryTree<String> d6 = new BinaryTree<String>("D6");
	
		BinaryTree<String> d1 = new BinaryTree<String>("D1");
		BinaryTree<String> d2 = new BinaryTree<String>("D2");
		
		
		BinaryTree<String> c1 = new BinaryTree<String>("C1",d1,d2);
		BinaryTree<String> c2 = new BinaryTree<String>("C2",d5,d6);
		BinaryTree<String> c3 = new BinaryTree<String>("C3",e1,e2);
		BinaryTree<String> c4 = new BinaryTree<String>("C4");
		
		BinaryTree<String> b1 = new BinaryTree<String>("B1",c1,c2);
		BinaryTree<String> b2 = new BinaryTree<String>("B2",c3,c4);
		BinaryTree<String> head = new BinaryTree<String>("A",b1,b2);

	
		System.out.println(head);
		
		System.out.println("\nTESTING PREORDER ITERATOR");
		for(Iterator<String> preiter = head.PreOrderIterator(); preiter.hasNext();)
		{
			System.out.println(preiter.next());
		}
		System.out.println("\nTESTING POSTORDER ITERATOR");
		for(Iterator<String> postiter = head.PostOrderIterator(); postiter.hasNext();)
		{
			System.out.println(postiter.next());
		}
		System.out.println("\nTESTING INORDER ITERATOR");
		for(Iterator<String> initer = head.InOrderIterator(); initer.hasNext();)
		{
			System.out.println(initer.next());
		}
		
    }
}
	
		

		
	


/**
Graveyard of tests
		System.out.println(head.value());
		head.setValue("swag");
		System.out.println(head.value());
		System.out.println(head.isLeaf());
		
		
				System.out.println(head.size());

		
		
		BinaryTree<String> d5 = new BinaryTree<String>("D5");
		BinaryTree<String> d6 = new BinaryTree<String>("D6");
	
		BinaryTree<String> d1 = new BinaryTree<String>("D1",null,d5);
		BinaryTree<String> d2 = new BinaryTree<String>("D2",d6,null);
		
		
		BinaryTree<String> c1 = new BinaryTree<String>("C1");
		BinaryTree<String> c2 = new BinaryTree<String>("C2",d1,null);
		BinaryTree<String> c3 = new BinaryTree<String>("C3",null,d2);
		BinaryTree<String> c4 = new BinaryTree<String>("C4");
		
		BinaryTree<String> b1 = new BinaryTree<String>("B1",c1,c2);
		BinaryTree<String> b2 = new BinaryTree<String>("B2",c3,c4);
		BinaryTree<String> head = new BinaryTree<String>("A",b1,b2);
*/
	