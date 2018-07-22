package com.sg3d;

public class Main {
    public static void main(String[] args) {
        GameBoard alfa = new GameBoard();
        System.out.println(alfa);
        TicTacToe game = new TicTacToe("Gigi", "Costel");
        game.play();
    }
}
