import java.util.Scanner;

public class RunnerTwentyQ
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to my Twenty (or more) Questions Game!");
		System.out.println("Please answer with a 'y' or a 'n'");
		System.out.println();
		TwentyQ game = new TwentyQ();
		TwentyQ.play(game.getRoot());
	}
}