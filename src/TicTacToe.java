/*
 * Javier Velazco
 * Florida International University
 */

import java.util.Scanner;

public class TicTacToe 
{    
    public static void main(String[] args) 
    {
    	Scanner input = new Scanner(System.in);
        Game game = new Game();
        
 
        System.out.println("Game is Starting...");
        
        int row, col;
        
        // While loop to run while we don't have a winner
        while (!game.checkCol() && !game.checkRow() && !game.checkDiag() && !game.checkTie())
        {
        	game.displayBoard();
        	
        	// While loop to make sure coordinate is valid
        	do
        	{
        		System.out.println("Curent Player: " + game.getCurrentPlayer());
        		System.out.print("Enter coordinate of empty spot to place mark: ");
        		row = input.nextInt() - 1;
            	col = input.nextInt() - 1;
        	}
        	while(!game.playTurn(row, col));

        	game.playTurn(row, col);
        	game.changePlayer();
        	game.displayBoard();
        }
        
        // Checking to make sure the game is either a tie or a win
        if (!game.checkCol() && !game.checkRow() && !game.checkDiag() && game.checkTie())
        {
        	System.out.println("Game is a Tie");
        }
        else
        {
        	game.changePlayer();
        	System.out.println("Player: " + game.getCurrentPlayer() + " Won");
        }
        
    }
    
}
