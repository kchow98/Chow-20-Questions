import java.util.Scanner;

/**
This is my Twenty Questions Game. It's memory is not saved after exiting.

Note: Left is Yes, Right is No.

@author Kevin Chow
@version 1.6.16
*/
public class TwentyQ
{
	//first question
	private static BinaryTree<String> root;
	
	/**
	Constructor. Sets first question to be "Is it alive?" and the possible answers to dog
	if yes, and headphones if no.
	*/
	public TwentyQ()
	{
		BinaryTree<String> leftstart = new BinaryTree<String>("Dog");
		BinaryTree<String> rightstart = new BinaryTree<String>("Headphones");
		root = new BinaryTree<String>("Is it alive?\n",leftstart, rightstart);
	}
	
	/**
	Accessor Method for root
	@return BinaryTree<String> the first question
	*/
	public BinaryTree<String> getRoot()
	{
		return root;
	}
	
	/**
	Method that interacts with the player and acts accordingly
	@param BinaryTree<String> node current node the game is looking at
	*/
	public static void play(BinaryTree<String> node)
	{
		if(!node.isLeaf())
		{
			System.out.println(node.value());
			Scanner in0 = new Scanner(System.in);
      		String answer = in0.nextLine();
      		
      		if (answer.equals("y") || answer.equals("Y"))
      		{
      			if (node.left() == null)
      			{
      				stumpedNotLeaf(node, true);
      				System.out.println("\nI accept my defeat. But...");
      				System.out.print("Let's play again! You Ready?");
      				System.out.println(" LET'S GO!");
 		      		System.out.println("---------------------------------------------------");

      				play(root);
      			}
      			
      			else
      			{
      				play(node.left());
      			}
      		}
      		
      		
      		else if(answer.equals("n") || answer.equals("N"))
      		{
      			if (node.right() == null)
      			{
      				stumpedNotLeaf(node, false);
      				System.out.println("\nI accept my defeat. But...");
      				System.out.print("Let's play again! You Ready?");
      				System.out.println(" LET'S GO!");
      				System.out.println("---------------------------------------------------");

      				play(root);
      			}
      			else
      			{
      			play(node.right());
      			}
      		}
		}
		
		else if(node.isLeaf())
		{
			System.out.println("Is the object you're thinking of: ");
			System.out.print(node.value());
			System.out.println();
			Scanner in1 = new Scanner(System.in);
      		String finalYesOrNo = in1.nextLine();
      		if (finalYesOrNo.equals("y") || finalYesOrNo.equals("Y"))
      		{
      			System.out.println("\nI win. I'm so smart!");
      			
      		}
      		else if(finalYesOrNo.equals("n") || finalYesOrNo.equals("N"))
      		{
      			stumpedLeaf(node);
      			System.out.println("\nI accept my defeat. But...");
      		}
      		
      		System.out.print("Let's play again! You Ready?");
      		System.out.println(" LET'S GO!");
      		System.out.println("---------------------------------------------------");
      		play(root);
			
		}
	}
	
	/**
	Helper Method that deals with the AI being stumped due to there being no answer that 
	could fit the answers given. Adjusts Binary Tree as needed.
	@parameter BinaryTree<String> n the node that was being looked at in the play method
	@parameter boolean posOrNeg true if the users answer to the last question was y, false
	if it was no. Used to determine if left or right pointer should be set.
	*/
	private static void stumpedNotLeaf(BinaryTree<String> n, boolean posOrNeg)
	{
		System.out.println("You stumped me! What were you thinking of?");
		Scanner in2 = new Scanner(System.in);
		String answerToAdd = in2.nextLine();
		
		BinaryTree<String> newAnswer= new BinaryTree<String>(answerToAdd);
		
		if(posOrNeg)
		{
			n.setLeft(newAnswer);
		}
		else
		{
			n.setRight(newAnswer);
		}		
		
	}

	/**
	Helper method that deals with the AI being stumped due to incorrect guess. Adjusts 
	Binary Tree as needed.
	@parameter BinaryTree<String> n the node that was being looked at in the play method
	*/
	private static void stumpedLeaf(BinaryTree<String> n)
	{
		System.out.println("You stumped me! What were you thinking of?");
		Scanner in2 = new Scanner(System.in);
		String answerToAdd = in2.nextLine();
		System.out.println("What is a question that would have differentiated my guess from your answer?");
		Scanner in3 = new Scanner(System.in);
		String questionToAdd = in3.nextLine();			
		
		String holdAnswer = n.value();
		n.setValue(questionToAdd);
		//BT of answer
		BinaryTree<String> answer = new BinaryTree<String>(answerToAdd);
		n.setLeft(answer);
		BinaryTree<String> oldAnswer = new BinaryTree<String>(holdAnswer);
		n.setRight(oldAnswer);
	}



}


















