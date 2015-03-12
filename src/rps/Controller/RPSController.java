package rps.Controller;

import javax.swing.JOptionPane;
/**
 * 
 * @author James Peck
 * @version 1.2 3/11/2015
 */
public class RPSController
{
	private int winCount;
	private int loseCount;
	private int tieCount;

	public RPSController()
	{
		this.winCount = 0;
		this.loseCount = 0;
		this.tieCount = 0;
	}

	/**
	 * main running of the program, holds most logic for the game.
	 */
	public void start()
	{
		String input = "";
		boolean runAgain = true;
		String comChoice = "";
		String winner = "";

		while (runAgain)
		{
			int autoChoice = (int) (Math.random() * 3);
			if (autoChoice == 0)
			{
				comChoice = "Rock";
			}
			else if (autoChoice == 1)
			{
				comChoice = "Paper";
			}
			else if (autoChoice == 2)
			{
				comChoice = "Scissors";
			}

			input = JOptionPane.showInputDialog(null, "Chose Rock Paper or Scissors", "Rock,Paper,Scissors", JOptionPane.QUESTION_MESSAGE);
			// JOptionPane.showMessageDialog(null, input);
			if(input == null)
			{
				runAgain = false;
				JOptionPane.showMessageDialog(null, "wins: " + winCount + "       Ties: " + tieCount + "       Loses: " + loseCount);
				
			}
			else
			{
				winner = CompareChoices(input, comChoice);
			}
			
			if (winner.length() > 10)
			{
				if (JOptionPane.showConfirmDialog(null, winner, "Uh Oh", JOptionPane.OK_CANCEL_OPTION) == 0)
				{
					runAgain = true;
				}
				else
				{
					runAgain = false;
					JOptionPane.showMessageDialog(null, "wins: " + winCount + "       Ties: " + tieCount + "       Loses: " + loseCount);
				}
			}
			else if (runAgain)
			{
				if (JOptionPane.showConfirmDialog(null, input + " VS. " + comChoice, winner, JOptionPane.OK_CANCEL_OPTION)== 0 )
				{
					runAgain = true;
				}
				else
				{
					runAgain = false;
					JOptionPane.showMessageDialog(null, "wins: " + winCount + "       Ties: " + tieCount + "       Loses: " + loseCount);
				}
			}
		}
	}

	/**
	 * compares the choice of the player with the computers auto choice to find the winner also 
	 * @param input Player choice
	 * @param comChoice Computer's choice
	 * @return returns the winner
	 */
	private String CompareChoices(String input, String comChoice)
	{
		String winner = "";

		if (input.equalsIgnoreCase("Rock"))
		{
			if (comChoice.equalsIgnoreCase("rock"))
			{
				winner = "You Tied";
				tieCount++;
			}
			else if (comChoice.equalsIgnoreCase("Paper"))
			{
				winner = "You Lose.";
				loseCount++;
			}
			else if (comChoice.equalsIgnoreCase("Scissors"))
			{
				winner = "You Win!";
				winCount++;
			}
		}
		else if (input.equalsIgnoreCase("Paper"))
		{
			if (comChoice.equalsIgnoreCase("paper"))
			{
				winner = "You Tied";
				tieCount++;
			}
			else if (comChoice.equalsIgnoreCase("Scissors"))
			{
				winner = "You Lose.";
				loseCount++;
			}
			else if (comChoice.equalsIgnoreCase("Rock"))
			{
				winner = "You Win!";
				winCount++;
			}
		}
		else if (input.equalsIgnoreCase("Scissors"))
		{
			if (comChoice.equalsIgnoreCase("Scissors"))
			{
				winner = "You Tied";
				tieCount++;
			}
			else if (comChoice.equalsIgnoreCase("Rock"))
			{
				winner = "You Lose.";
				loseCount++;
			}
			else if (comChoice.equalsIgnoreCase("paper"))
			{
				winner = "You Win!";
				winCount++;
			}
		}
		else
		{
			winner = "please enter rock paper or scissors";
		}
		return winner;
	}
}
