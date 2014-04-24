/*
 * FizzBuzz in Java
 *     by Reece Notargiacomo
 */
import java.io.*;

public class FizzBuzz {
	private InputStreamReader istream = new InputStreamReader(System.in) ;
	private BufferedReader bufRead = new BufferedReader(istream) ;

    public static void main(String[] args) {

        //initialise a new instance, and run
    	FizzBuzz newFizzBuzz = new FizzBuzz();
    	newFizzBuzz.run();
    }

    public void run() {
    	//Introduction and instruction
    	showIntro();

        //for numbers 1 to 100,
    	for(int i = 1; i <= 100; i++)
    	{
            //grab user input
            String userInput = recordLine();

            String answer = "";
    		if(i%3==0) answer += "fizz";
    		if(i%5==0) answer += "buzz";
    		if (answer=="")
    			answer += Integer.toString(i);

			if(answer.equals(userInput.toLowerCase())) {
				if(i!=100)
					System.out.println("    Correct!"); //correct answer
				else {
					System.out.println("Congratulations,
						you've completed 1 to 100!"); //correct answer
					System.out.println();
				}
			} else {
				//incorrect answer ends the game
				gameOver(answer);
				break;
			}
    	}

    	//restart game after losing
    	this.run();
    }

    private String recordLine() {
    	String input = "";
    	try {
     		input = bufRead.readLine();
		}
		catch (IOException err) {
			System.out.println("Error reading line");
     		return "ERR";
		}

		if(input.equals("f")) input = "fizz";
		if(input.equals("fb")) input = "fizzbuzz";
		if(input.equals("b")) input = "buzz";

		if(input.equals("!help")) {
            showHelp();
            input = recordLine();
		}

		if(input.equals("!quit"))
            System.exit(0);

     	return input;
    }

    private void showIntro() {
    	System.out.println();
    	System.out.println("//Welcome to FizzBuzz in Java");
    	System.out.println("//type !help for the rules.");
    	System.out.println();
    	System.out.println("Let's go! (Starting with 1)");
    	System.out.println();
    }

    private void showHelp() {
    	System.out.println();
    	System.out.println("//FizzBuzz help");
    	System.out.println("//  For multiples of 3, type \"fizz\"
    		or \"f\"");
    	System.out.println("//  For multiples of 5, type \"buzz\"
    		or \"b\"");
    	System.out.println("//  For multiples of both, type \"fizzbuzz\"
    		or \"fb\"");
    	System.out.println("//  To exit the game safely, type \"!quit\"");
    	System.out.println();
    	System.out.println("Let's continue! (Starting from last number)");
    }

    private void gameOver(String expectedAnswer) {
    	System.out.println("Wrong answer. ("+expectedAnswer+")");
    	System.out.println();
    	System.out.print("Game Over, press <ENTER> to continue.");
    	recordLine();
    }
}
