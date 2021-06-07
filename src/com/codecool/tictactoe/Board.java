package com.codecool.tictactoe;

public class Board {

    public final int ROWS = 3;
    public final int COLS = 3;
    private String abc = "ABC";
    private Cell[][] cells;
    private int currentRow, currentCol;

    public Board() {
        cells = new Cell[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col] = new Cell(row,col);
            }
        }
    }

    public void initBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col].clearCell();
            }
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (cells[row][col].getCellContent() == Cell.CellContent.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(Cell.CellContent cellMark) {
        return (cells[currentRow][0].getCellContent() == cellMark
                && cells[currentRow][1].getCellContent() == cellMark
                && cells[currentRow][2].getCellContent() == cellMark
            || cells[0][currentCol].getCellContent() == cellMark
                && cells[1][currentCol].getCellContent() == cellMark
                && cells[2][currentCol].getCellContent() == cellMark
            || currentRow == currentCol
                && cells[0][0].getCellContent() == cellMark
                && cells[1][1].getCellContent() == cellMark
                && cells[2][2].getCellContent() == cellMark
            || currentRow + currentCol == 2
                && cells[0][2].getCellContent() == cellMark
                && cells[1][1].getCellContent() == cellMark
                && cells[2][0].getCellContent() == cellMark);
    }

    public void printBoard() {
        for (int i = 0; i < COLS; i++) {
            System.out.print("   ");
            System.out.print(i+1);
        }

        for (int row = 0; row < ROWS; row++) {
            System.out.println("");
            System.out.print(abc.charAt(row));
            for (int col = 0; col < COLS; col++) {
                cells[row][col].printCell();
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
}
