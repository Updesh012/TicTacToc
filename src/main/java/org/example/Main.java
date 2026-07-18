package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Setup players
        Player p1 = new HumanPlayer("Updesh", Symbol.X);
        Player p2 = new HumanPlayer("Rahul", Symbol.O);

        // Create game
        Game game = new Game(3, List.of(p1, p2));

        System.out.println("=== Tic-Tac-Toe ===");
        game.getBoard().display();

        // Game loop
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player current = game.getCurrentPlayer();
            System.out.println(current.getName() + " (" + current.getSymbol() + ") - Enter row col:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            try {
                GameStatus result = game.makeMove(row, col);
                game.getBoard().display();

                if (result == GameStatus.X_WON || result == GameStatus.O_WON) {
                    System.out.println(current.getName() + " WINS!");
                } else if (result == GameStatus.DRAW) {
                    System.out.println("It's a DRAW!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
}
