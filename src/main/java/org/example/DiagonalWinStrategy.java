package org.example;

public class DiagonalWinStrategy implements WinningStrategy{

    @Override
    public boolean checkWin(Board board, int lastRow, int lastCol, Symbol symbol) {
        // Only check if the move is on the main diagonal
        if (lastRow != lastCol) return false;

        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
