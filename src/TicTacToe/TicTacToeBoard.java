package TicTacToe;

/**
 * Created by csheare on 1/14/2017.
 */
public class TicTacToeBoard {

    public Square[][] board;
    public static final int DEFAULT_DIMENSION = 3;
    public static int turnsTaken = 0;
    public TicTacToeBoard(){
        board = new Square[DEFAULT_DIMENSION][DEFAULT_DIMENSION];
        makeEmpty();
    }

    public void makeEmpty(){
        for(int i = 0;i<DEFAULT_DIMENSION;i++) {
            for (int j = 0; j < DEFAULT_DIMENSION; j++) {
                board[i][j]= new Square(i,j);
            }
        }
    }

    /**
     *
     * @param  x coord
     * @param y coord
     * @return X,O,or EMPTY
     */
    public Status getSquare(int x,int y){
        return board[x][y].stat;
    }
    public boolean takeTurn(int x, int y, Status player){

        if (x < 0 | x > (DEFAULT_DIMENSION - 1) | y < 0 | y > (DEFAULT_DIMENSION - 1)) {
            System.out.print("OUT OF GAME BOARD, guess between 0-2");
            return false;
        }else if (!board[x][y].stat.equals(Status.EMPTY)) {
            System.out.print("Already used, try again");
            return false;
        } else {
            // System.out.print("Hit");
            if (player.equals(Status.X)) {
                board[x][y].stat = Status.X;
            } else {
                board[x][y].stat = Status.O;
            }
            return true;
        }

    }
    public boolean hasWon(Status s){
        int count = 0;
        //Vertical
        for(int c = 0;c<DEFAULT_DIMENSION;c++) {
            for (int r = 0; r < DEFAULT_DIMENSION; r++) {
                if (board[r][c].stat.equals(s)) count++;
            }
            if (count == 3) return true;
            count = 0;//reset
        }
        //Horizontal
        for(int c = 0;c<DEFAULT_DIMENSION;c++) {
            for (int r = 0; r < DEFAULT_DIMENSION; r++) {
                if (board[c][r].stat.equals(s)) count++;
            }
            if (count == 3) return true;
            count = 0;//reset
        }
        //Diagonal
        for(int i = 0;i<DEFAULT_DIMENSION;i++) {
            if (board[i][i].stat.equals(s)) count++;
        }
        if (count == 3) return true;
        count = 0;

        for(int i = DEFAULT_DIMENSION-1;i>=0;i--){
            if (board[i][(DEFAULT_DIMENSION-1)-i].stat.equals(s)) count++;
        }
        if (count == 3) return true;

        return false;
    }
    public boolean isGameOver(){
        if(hasWon(Status.O)){
            System.out.println("O won");
            return true;
        }
        else if(hasWon(Status.X)){
            System.out.println("X won");
            return true;
        }
        else if(turnsTaken == 9){
            System.out.println("No winner");
            return true;
        }
        else{
            return false;
        }
    }

    public void displayBoard(){
        for(int i = 0;i<DEFAULT_DIMENSION;i++){
            for(int j =0;j<DEFAULT_DIMENSION;j++){
                if(getSquare(i,j) == Status.EMPTY) {
                    System.out.print("|_|");
                }
                else if(getSquare(i,j) == Status.X){
                    System.out.print(("|X|"));
                }
                else{
                    System.out.print("|O|");
                }
            }
            System.out.println();
        }
    }

}
