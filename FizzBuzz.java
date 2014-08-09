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
		fbGameInstance.startGame();
	}

	public void startGame()
	{
		int answer;
		int userInput;

		//for numbers 1 to 100,
		for(int i = 1; i <= 100; i++) {
			answer = 0;
			if(i%3==0) answer -= 1; //-1 for fizz, -2 for buzz
			if(i%5==0) answer -= 2; //-3 for fizzbuzz
			
			if(answer==0)
				answer = i;	// if not fizz or buzz (or both)

			// get User Input as a number
			if(answer == Integer.parseInt(inputLine().toString())) {
				if(i!=100)
					System.out.println("Correct!"); //correct answer
				else 
					endGame(true,i); 
			} else {
				endGame(false,i);
				break;
			}
		}

		//restart game after losing
		this.startGame();
	}

	private String inputLine() {
		
		String input = "";

		try {input = bufferedRead.readLine();}
		catch (IOException err){
			System.out.println("Error reading line: "+err);}

		switch(input) {
			case "f":
			case "fizz":
				input = "-1";
				break;
			case "b":
			case "buzz":
				input = "-2";
				break;
			case "fb":
			case "fizzbuzz":
				input = "-3";
				break;
			case "help":
				input = displayHelp();
				break;
			case "quit":
				System.exit(0);
				break;
		}
		
		// prepare input to be returned to game
		try {Integer.parseInt(input);}
		catch(NumberFormatException e) {return false;}

		return input;
	}

	private void displayIntro() {
		System.out.println();
		System.out.println("//Welcome to FizzBuzz in Java");
		System.out.println("//type !help for the rules.");
		System.out.println();
		System.out.println("Let's go! (Starting with 1)");
		System.out.println();
	}

	private void displayHelp() {
		System.out.println();
		System.out.println("//FizzBuzz help");
		System.out.println("//  For multiples of 3, type \"fizz\" or \"f\"");
		System.out.println("//  For multiples of 5, type \"buzz\" or \"b\"");
		System.out.println("//  For multiples of both, type \"fizzbuzz\" or \"fb\"");
		System.out.println("//  To exit the game safely, type \"quit\" or \"exit\"");
		System.out.println();
		System.out.println("Let's continue! (Starting from last number)");
		return inputLine();
	}

	private void endGame(boolean userWins,int expectedAnswer)
	{
		if(userWins)
			System.out.println("Nice one!, you got every answer correct!");
		else {
			System.out.println("Wrong answer. ("+expectedAnswer+")");
			System.out.println();
			System.out.print("Game Over, press <ENTER> to continue.");
			inputLine();
		}
	}
}
