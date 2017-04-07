/*
 * Javier Velazco
 * Florida International University
 */


public class Game 
{
    private final int ROW = 3;
    private final int COL = 3;
    private char[][] gameBoard = new char[ROW][COL];
    private char currentPlayer;
    
    
    /**
     * Constructor to start game, sets the board and automatically 
     * assigns first player to be X
     */
    public Game()
    {
        setBoard();
        currentPlayer = 'X';
    }
    
    /**
     * Initializes the board
     */
    public void setBoard()
    {
    	for (int rows = 0; rows < ROW; rows++)
        {
            for (int cols = 0; cols < COL; cols++)
            {
                gameBoard[rows][cols] = '*';
            }
        }
    }
    
    /**
     * Displays the board at its current status in game
     */
    public void displayBoard()
    {
    	System.out.println("    1   2   3");
    	System.out.println("---------------");
        for (int rows = 0; rows < ROW; rows++)
        {
            System.out.print( (rows + 1) + " | ");
            
            for (int cols = 0; cols < COL; cols++)
            {
                
                System.out.print(gameBoard[rows][cols] + " | ");
                
            }
            
            System.out.println();
            System.out.println("---------------");
        }
    }
    
    /**
     * Changes player between X and O
     */
    public void changePlayer()
    {
    	if (currentPlayer == 'X')
    	{
    		currentPlayer = 'O';
    	}
    	else
    	{
    		currentPlayer = 'X';
    	}
    }
    
    /**
     * Gets the current player
     * @return The current player
     */
    public char getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    /**
     * Checks rows to see if there is a win
     * @return True if any row contains all three of the same mark, otherwise false
     */
    public boolean checkRow()
    {
    	for (int rows = 0; rows < ROW; rows++)
        {
            if (gameBoard[rows][0] == gameBoard[rows][1] && gameBoard[rows][1] == gameBoard[rows][2]
            		&& gameBoard[rows][2] != '*')
            {
            	return true;
            }
        }
		return false;
    }
    
    /**
     * Checks columns to see if there is a win
     * @return True if any column contains all three of the same mark, otherwise false
     */
    public boolean checkCol()
    {
    	for (int cols = 0; cols < ROW; cols++)
        {
            if (gameBoard[0][cols] == gameBoard[1][cols] && gameBoard[1][cols] == gameBoard[2][cols]
            		&& gameBoard[2][cols] != '*')
            {
            	return true;
            }
        }
		return false;
    }
    
    /**
     * Checks diagonally to see if there is a win
     * @return True if any diagonal contains all three of the same mark, otherwise false
     */
    public boolean checkDiag()
    {
    	if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] 
    			&& gameBoard[2][2] != '*')
    	{		
    		return true;
    	}
    	else if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] 
    			&& gameBoard[0][2] != '*')
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    /**
     * Checks to see if the board is completely filled, making it a tie
     * @return False if any set of coordinate contains the * string, otherwise true
     */
    public boolean checkTie()
    {
    	for (int rows = 0; rows < ROW; rows++)
        {
            for (int cols = 0; cols < COL; cols++)
            {
                if (gameBoard[rows][cols] == '*')
                {
                	 return false;
                }
            }
        }
    	return true;
    }
    
    /**
     * @param row coordinate for rows
     * @param col coordinate for columns
     * @return True if set of coordinate is a valid entry, meaning it is not already occupied,
     * otherwise false
     */
    public boolean playTurn(int row, int col)
    {
    	if(row >= 0 && row < 3)
    	{
    		if(col >= 0 && row < 3)
    		{
    			if(gameBoard[row][col] == '*')
    			{
    				gameBoard[row][col] = currentPlayer;
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
}
