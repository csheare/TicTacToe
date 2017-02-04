package TicTacToe;

/**
 * Created by csheare on 1/14/2017.
 */
public class Square {
    public int row,col;
    public Status stat;

    public Square(int r,int c){
        row = r;
        col = c;
        stat = Status.EMPTY;
    }

    public boolean equals(Object o){
        if(!(o instanceof Square)){
            return false;
        }
        Square rhs = (Square)o;
        return (rhs.row == row && rhs.col==col);

    }

}
