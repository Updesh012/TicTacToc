package org.example;

import java.util.Random;

public class BotPlayer extends Player{

    public BotPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    public int[] getMove(Board board) {
        Random random = new Random();
        int size = board.getSize();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (!board.isValidMove(row, col));
        return new int[]{row, col};
    }
}
