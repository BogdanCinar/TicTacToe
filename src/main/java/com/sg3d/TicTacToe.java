package com.sg3d;

import java.util.Scanner;

public class TicTacToe {
    private Boolean xTurn;
    private Player player1;
    private Player player2;
    private GameBoard board;
    private Scanner sc;

    public TicTacToe(String player1Name, String player2Name) {
        this.xTurn = true;
        this.player1 = new Player(player1Name, GameBoard.Mark.MARK_X);
        this.player2 = new Player(player2Name, GameBoard.Mark.MARK_0);
        this.board = new GameBoard();
        this.sc = new Scanner(System.in);
    }


    private int[] getCoordinates() {
        int a = 0;
        int b = 0;
        do {
            System.out.println("Insert move location");
            a = sc.nextInt();
            b = sc.nextInt();
        } while (a < 1 || a > 3 || b < 1 || b > 3);
        return new int[]{a, b};
    }

    public void play() {

        while (!board.isGameOver()) {
            int[] coord = getCoordinates();
            boolean moveResult = board.move(coord, xTurn ? GameBoard.Mark.MARK_X : GameBoard.Mark.MARK_0);
            if (moveResult) {
                xTurn = !xTurn;
                System.out.println(board);
            }
        }
        sc.close();
        if (board.isWinner(GameBoard.Mark.MARK_X)) {
            System.out.println("Bravo " + player1);
        } else if (board.isWinner(GameBoard.Mark.MARK_0)) {
            System.out.println("Bravo " + player2);
        } else {
            System.out.println("Remiza  !");
        }
    }
}
