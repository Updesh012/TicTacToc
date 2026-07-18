package org.example;

public interface WinningStrategy {
    boolean checkWin(Board board, int lastRow, int lastCol, Symbol symbol);
}
