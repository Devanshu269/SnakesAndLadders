package service;

import enums.GameStatus;
import enums.PlayerType;
import model.Board;
import model.Dice;
import model.Game;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Helper to build a Game by reading input from the console.
 * This moves the interactive code out of `Main` so the builder can be reused/tested.
 */
public class GameBuilder {

    public Game buildFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello and welcome! Let's play a game of Snakes and Ladders!\n");

        System.out.println("What board size would you prefer?");
        int boardSize = sc.nextInt();

        System.out.println("Number of Ladders");
        int numberOfLadders = sc.nextInt();

        System.out.println("Number of Snakes");
        int numberOfSnakes = sc.nextInt();
        
        Board board = new Board(boardSize, numberOfSnakes, numberOfLadders);

        System.out.println("So the Snakes (head -> tail) are at positions:");
        board.getSnakes().forEach((head, tail) -> System.out.println("Head: " + head + " Tail: " + tail));
        System.out.println();

        System.out.println("And the Ladders (bottom -> top) are at positions:");
        board.getLadders().forEach((bottom, top) -> System.out.println("Bottom: " + bottom + " Top: " + top));
        System.out.println();

        System.out.println("How many players will be playing?");
        int numberOfPlayers = sc.nextInt();

        System.out.println("Do you want to have a bot with you? (y/n)");

        boolean hasBot = sc.next().equalsIgnoreCase("y");

        if (hasBot && numberOfPlayers > 0) {
            numberOfPlayers--;
        }

        List<Player> players = new ArrayList<>();
        if (hasBot) {
            players.add(new Player("Bot", PlayerType.BOT, 0));
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1) + ":");
            String name = sc.next();
            players.add(new Player(name, PlayerType.HUMAN, 0));
        }

        System.out.println("Do you want custom number of Dices and Faces? (y/n) If 'n' then default value will be 1 Dice and 6 faces");
        int diceCount = 1;
        int diceFaces = 6;
        
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("What will be the number of Dice?");
            diceCount = sc.nextInt();
            System.out.println("What will be the number of faces?");
            diceFaces = sc.nextInt();
        }
        Dice dice = new Dice(diceCount, diceFaces);

        return new Game(board, players, dice, GameStatus.FINISHED, 0);

    }
}

