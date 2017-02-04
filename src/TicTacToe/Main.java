package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static TicTacToe.Status.O;
import static TicTacToe.Status.X;

//TestComment

/**
 * Created by csheare on 1/14/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        TicTacToeBoard gameboard = new TicTacToeBoard();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        gameboard.displayBoard();
        Status[] players = new Status[2];
        players[0]= X;
        players[1] = O;
        int current = 0;
        boolean validTurn = false;
        while (!gameboard.isGameOver()) {
            System.out.printf("\nPLAYER %s TURN\n", players[current]);

            Square s = parseSquares(reader.readLine());
            validTurn = gameboard.takeTurn(s.row, s.col, players[current]);
            while (!validTurn){
                Square n = parseSquares(reader.readLine());
                validTurn = gameboard.takeTurn(n.row, n.col, players[current]);
            }
            gameboard.displayBoard();
            current = (current + 1) % 2;
            //validTurn = false;
        }



        //}


    }
    public static Square parseSquares(String input) {
        // split the input string into tokens
        String[] tokens = input.split("\\D+");

        // parse each token as an integer
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        return new Square(x, y);
    }
}

