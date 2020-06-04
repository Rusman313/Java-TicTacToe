public class TicTacToeClass
{
	// Instance Variables
	private char[][] board;
    private int turns;


	// Constructors
	public TicTacToeClass()
	{
		board = new char[3][3];
		turns = 0;

		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}

	// Accessor Methods

    public boolean isWinner(char p) {
        for (int r = 0; r < 3; r++) {// will iterate through row numbers
            if (p == board[r][0] && p == board[r][1] && p == board[r][2]) // will check horizontal win
                return true;
        }
        for (int c = 0; c < 3; c++) {// will iterate through column numbers 
            if (p == board[0][c] && p == board[1][c] && p == board[2][c])// will check for vertical win
                return true;
        }
        if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;// will check diagonal win from bottom left to upper right
        } else if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;// will check diagonal win from upper left to lower right
        } else {
            return false;// otherwise there is no winner
        }
    }

	public boolean isFull()
	{
		if (turns >= 9){// turns are >= 9 then the board is full
			return true;       
		}
		return false;
	}

	public boolean isCat()//cat means tie
	{// if the board is full and there is no winner its a tie
		if (isFull() && !isWinner('X') && !isWinner('O')){
			return true;
		};
		return false;	
	}

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
            return true;
        } else {
            return false;
        }
    }

	public int numTurns()
	{
		return turns;
	}

	public char playerAt( int r, int c )
	{
		if ( isValid(r,c) )
			return board[r][c];
		else
			return '@';
	}

	public void displayBoard()
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	// Modifiers
	public void playMove( char p, int r, int c )
	{ board[r][c]=p;
		turns++;
	}

}