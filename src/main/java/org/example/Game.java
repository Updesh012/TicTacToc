package org.example;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private GameStatus status;
    private List<WinningStrategy> winningStrategies;

    public Game(int boardSize, List<Player> players) {
        this.board = new Board(boardSize);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.status = GameStatus.IN_PROGRESS;

        this.winningStrategies = List.of(
                new RowWinStrategy(),
                new ColWinStrategy(),
                new DiagonalWinStrategy(),
                new AntiDiagonalWinStrategy()
        );
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public GameStatus makeMove(int row, int col) {
        if (status != GameStatus.IN_PROGRESS)
            throw new IllegalStateException("Game is already over!");

        Player current = getCurrentPlayer();

        // Validate and place
        board.makeMove(row, col, current.getSymbol());

        // Check all winning strategies
        if (checkWin(row, col, current.getSymbol())) {
            status = (current.getSymbol() == Symbol.X)
                    ? GameStatus.X_WON
                    : GameStatus.O_WON;
            return status;
        }

        // Check draw
        if (board.isFull()) {
            status = GameStatus.DRAW;
            return status;
        }

        // Switch turn
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return GameStatus.IN_PROGRESS;
    }

    private boolean checkWin(int row, int col, Symbol symbol) {
        // Run ALL strategies — if ANY returns true, it's a win
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWin(board, row, col, symbol)) {
                return true;
            }
        }
        return false;
    }

    public Board getBoard() { return board; }
    public GameStatus getStatus() { return status; }
}
