/**
 * FizzBuzz in Java
 *  @author Reece Notargiacomo
 **/

import java.io.*;

public class FizzBuzz {

	private InputStreamReader inputStream = new InputStreamReader(System.in);
	private BufferedReader bufferedRead = new BufferedReader(inputStream);

	public static void main(String[] args) {
		FizzBuzz fbGameInstance = new FizzBuzz();
		fbGameInstance.displayIntro();
		fbGameInstance.startGame(1);
	}

	public void startGame(int startNum)
	{
		int answer;
		int userInput;

		System.out.println("Let's go! (Starting with "+startNum+")");
		System.out.println();

		//for numbers 1 to 100,
		for(int i = startNum; i <= startNum+99; i++) {
			answer = 0;
			if(i%3==0) answer -= 1; //-1 for fizz, -2 for buzz
			if(i%5==0) answer -= 2; //-3 for fizzbuzz
			
			if(answer==0)
				answer = i;	// if not fizz or buzz (or both)

			// get User Input as a number
			if(answer == getUserInput())
				if(i!=100)
					System.out.println("Correct!"); //correct answer
				else 
					endGame(true,i); 
			else {
				endGame(false,i);
				break;
			}
		}

		//restart game after losing
		this.startGame(startNum);
	}

	private int getUserInput() {
		
		String input = "";

		try {
			input = bufferedRead.readLine();
		} catch (IOException err) {
			System.out.println("Error reading line: "+err);
			return getUserInput();
		}
		
		if("f".equals(input) || "fizz".equals(input))
			return -1;
		if("b".equals(input) || "buzz".equals(input))
			return -2;
		if("fb".equals(input) || "fizzbuzz".equals(input))
			return -3;
		if("exit".equals(input))
			System.exit(0);

		// prepare input to be returned to game
		try {return Integer.parseInt(input);}
		catch(NumberFormatException e) {return 0;}
	}

	private void displayIntro() {
		System.out.println();
		System.out.println("Welcome to FizzBuzz (in Java)");
		System.out.println();
		System.out.println("  > the aim of the game is to count from 1 to 100");
		System.out.println("  > but for multiples of 3, type \"fizz\" or \"f\" instead of the number");
		System.out.println("  > and for multiples of 5, type \"buzz\" or \"b\"");
		System.out.println("  > for multiples of both, type \"fizzbuzz\" or \"fb\"");
		System.out.println();
		System.out.println("Type \"exit\" to quit the game");
		System.out.println();
	}

	private void endGame(boolean userWins,int expectedAnswer)
	{
		if(userWins)
			System.out.println("Nice one!, you got every answer correct!");
		else {
			System.out.println("Wrong answer!");
			System.out.println();
			System.out.print("Game Over: Press <ENTER> to start again.");
			getUserInput();
		}
	}
}
