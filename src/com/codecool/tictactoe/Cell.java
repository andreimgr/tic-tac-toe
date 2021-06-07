package com.codecool.tictactoe;

public class Cell {

    public enum CellContent {
        EMPTY,
        CROSS,
        CIRCLE
    }

    private CellContent cellContent;
    private int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void clearCell () {
        cellContent = CellContent.EMPTY;
    }

    public void printCell() {
        switch (cellContent) {
            case EMPTY -> System.out.print(" . |");
            case CIRCLE -> System.out.print(" O ");
            case CROSS -> System.out.print(" X ");
        }
    }

    public CellContent getCellContent() {
        return cellContent;
    }

    public void setCellContent(CellContent cellContent) {
        this.cellContent = cellContent;
    }


}
