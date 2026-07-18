package org.example;

public class Board {

    private Cell[][] grid;
    private int size;
    private int movesCount;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        this.movesCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row < this.size && row >= 0 && col < this.size && col >= 0 && grid[row][col].isEmpty();
    }

    public void makeMove(int row, int col, Symbol symbol) {
        if (!isValidMove(row, col)) throw new IllegalArgumentException("Invalid move: " + row + "," + col);

        grid[row][col].setSymbol(symbol);
        movesCount++;
    }

    public boolean isFull() {
        return this.movesCount == size * size;
    }

    public Cell getCell(int row, int col) { return grid[row][col]; }

    public int getSize() { return size; }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol s = grid[i][j].getSymbol();
                String ch = (s == Symbol.EMPTY) ? "." : s.name();
                System.out.print(" " + ch + " ");
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-".repeat(size * 4 - 1));
            }
        }
        System.out.println();
    }
}
