package org.example;

public class RowWinStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int lastRow, int lastCol, Symbol symbol) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            if (board.getCell(lastRow, i).getSymbol() != symbol) return false;
        }
        return true;
    }
}
