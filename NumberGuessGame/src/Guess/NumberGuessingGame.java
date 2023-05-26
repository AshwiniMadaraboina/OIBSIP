package Guess;
import java.util.Random;
import javax.swing.*;
public class NumberGuessingGame{
	public static void main(String args[]) {
		Random r=new Random();
		int generatingnumber=1+r.nextInt(100);
		int guessednumber=0;
		int count=1;
		while(generatingnumber!=guessednumber) {
			String response=JOptionPane.showInputDialog(null,"Enter a guess number between 1 and 100","NumberGuessingGame",1);
			guessednumber=Integer.parseInt(response);
			JOptionPane.showMessageDialog(null,""+determineGuess(guessednumber,generatingnumber,count));
			if(count>5) {
				break;
			}
			count++;
			
		}
		
	}
	public static String determineGuess(int guessednumber,int generatednumber,int count) {
		if(count>5) {
			return "attemps are finished!!! YOU LOSS THE GAME !!!";
		}
		else if(guessednumber<=0 || guessednumber>100) {
			return "Your guesss is invalid";
		}
		else if(guessednumber==generatednumber) {
			return "Correct!\nTotalGuesses:"+count+"  "+"total_score  = "+" "+1000/count;
		}
		else if(guessednumber>generatednumber) {
			return "Your guess is too high,try again"+count;
		}
		else if(guessednumber<generatednumber) {
			return  "Your guess is too low,try again"+count;
		}
		else {
			return "your guess is incorrect\n Try number:"+count;
		}
	}
	}
