package TicTacToe;

/**
 * Created by csheare on 2/3/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by csheare on 1/28/2017.
 */
public class XOButton extends JButton{
    ImageIcon X,O;
    static byte value = 0;
    int row;
    int col;
    Status stat;
    //boolean used = false;
    /*
    0:nothing
    1:X
    2:O
     */
    public XOButton(int row, int col){
        O = new ImageIcon(this.getClass().getResource("O.png"));
        X = new ImageIcon(this.getClass().getResource("X.png"));
        //this.addActionListener(e -> btnClick(e));
        this.row = row;
        this.col = col;
        stat = Status.EMPTY;
    }

    public void setXO(ImageIcon a){
        setIcon(a);
    }


}
