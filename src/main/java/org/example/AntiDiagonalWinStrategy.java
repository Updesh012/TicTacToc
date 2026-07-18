package org.example;

public class AntiDiagonalWinStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int lastRow, int lastCol, Symbol symbol) {
        int size = board.getSize();
        // Only check if the move is on the anti-diagonal
        if (lastRow + lastCol != size - 1) return false;

        for (int i = 0; i < size; i++) {
            if (board.getCell(i, size - 1 - i).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
