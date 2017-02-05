package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static TicTacToe.Status.O;
import static TicTacToe.Status.X;


/**
 * Created by csheare on 1/28/2017.
 */
public class TTTGUI extends JFrame {
    static int turn = 0;
    ImageIcon O = new ImageIcon(this.getClass().getResource("O.png"));
    ImageIcon X = new ImageIcon(this.getClass().getResource("X.png"));
    JPanel p = new JPanel();
    XOButton buttons[][] = new XOButton[3][3];
    TicTacToeBoard gameboard = new TicTacToeBoard();


    public static void main(String[] args) throws IOException {
        new TTTGUI();

    }
    public TTTGUI() {
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new XOButton(i, j);
                buttons[i][j].addActionListener(e -> btnClick(e));
                p.add(buttons[i][j]);
            }
            add(p);
            setVisible(true);


        }
    }

    private void btnClick(ActionEvent e)
    {   //player 1 = X/0
        //player 2 = O/1
        if(turn == 0){
            JOptionPane.showMessageDialog(null,
                    "PLAYER" + turn , "TURN",
                    JOptionPane.INFORMATION_MESSAGE);
            XOButton btn = (XOButton) e.getSource();
            btn.setXO(X);
            btn.stat = Status.X;
            gameboard.takeTurn(btn.row,btn.col,btn.stat);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "PLAYER" + turn , "TURN",
                    JOptionPane.INFORMATION_MESSAGE);
            XOButton btn = (XOButton) e.getSource();
            btn.setIcon(O);
            btn.stat = Status.O;
            gameboard.takeTurn(btn.row,btn.col,btn.stat);

        }


        if(gameboard.isGameOver() == false){
            turn = (turn + 1) % 2;
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "", "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }


    }
}