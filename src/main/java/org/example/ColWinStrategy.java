package org.example;

public class ColWinStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int lastRow, int lastCol, Symbol symbol) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            if (board.getCell(row, lastCol).getSymbol() != symbol)
                return false;
        }

        return true;
    }
}
