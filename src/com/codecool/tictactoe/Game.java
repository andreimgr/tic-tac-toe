package com.codecool.tictactoe;

import java.util.Scanner;

public class Game {

    public enum GameState {
        PLAYING,
        DRAW,
        CROSS_WON,
        CIRCLE_WON
    }

    private GameState gameState;
    private Board board;
    private Cell.CellContent cellContent;

    private Scanner in = new Scanner(System.in);

    public Game() {
        board = new Board();

        initGame();

        do {
            playerMove(cellContent);
            board.printBoard();
            updateGameState(cellContent);

            if (gameState == GameState.CROSS_WON) {
                System.out.println("X WON");
            } else if (gameState == GameState.CIRCLE_WON) {
                System.out.println("O WON");
            } else if (gameState == GameState.DRAW) {
                System.out.println("DRAW");
            }

            if (cellContent == Cell.CellContent.CROSS) {
                cellContent = Cell.CellContent.CIRCLE;
            } else cellContent = Cell.CellContent.CROSS;

        } while (gameState == GameState.PLAYING);
    }

    public void initGame() {
        board.initBoard();
        cellContent = Cell.CellContent.CROSS;
        gameState = GameState.PLAYING;
    }

    public void playerMove(Cell.CellContent cellMark) {
        boolean validInput = false;

        do {
            if (cellMark == Cell.CellContent.CROSS) {
                System.out.println("Player X, enter move: ");
            } else {
                System.out.println("Player O, enter move: ");
            }

            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;

            if (row >= 0 && row < board.ROWS && col >= 0 && col < board.COLS && board.getCells()[row][col].getCellContent() == Cell.CellContent.EMPTY) {
                board.getCells()[row][col].setCellContent(cellMark);
                board.setCurrentRow(row);
                board.setCurrentCol(col);
                validInput = true;
            } else {
                System.out.println("Not a valid move");
            }
        } while (!validInput);
    }

    public void updateGameState(Cell.CellContent cellMark) {
        if (board.hasWon(cellMark)) {
            if (cellMark == Cell.CellContent.CROSS) {
                gameState = GameState.CROSS_WON;
            } else if (cellMark == Cell.CellContent.CIRCLE) {
                gameState = GameState.CIRCLE_WON;
            } else {
                gameState = GameState.DRAW;
            }
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
