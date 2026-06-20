package service;

import enums.GameStatus;
import enums.PlayerType;
import model.Game;
import model.Player;

import java.util.List;
import java.util.Random;

public class GameService {
    Random random = new Random();

    public void gameStart(Game game) {

        System.out.println("Game Started \n");
        game.setGameStatus(GameStatus.IN_PROGRESS);
        game.setCurrentPlayerIndex(random.nextInt(game.getPlayers().size()));

        boolean firstTurn = true;
        while(game.gameStatus == GameStatus.IN_PROGRESS){
            if(firstTurn) {
                System.out.println(game.getPlayers().get(game.getCurrentPlayerIndex()).getName() +  " is starting the game \n");
                firstTurn = false;
            }
            PlayerService playerService = new PlayerService();
            playerService.takeTurn(game, game.getPlayers().get(game.getCurrentPlayerIndex()));

            boolean ifWin = checkIfWinner(game);
            if(ifWin) {
                break;
            }
            checkForSnakesAndLadders(game);
            game.setCurrentPlayerIndex((game.getCurrentPlayerIndex() + 1) % game.getPlayers().size());
        }

    }

    private boolean checkIfWinner(Game game) {
        if(game.getPlayers().get(game.getCurrentPlayerIndex()).getPosition() == game.getBoard().getSize()) {
            System.out.println(game.getPlayers().get(game.getCurrentPlayerIndex()).getName() + " has won the game! \n");
            game.setGameStatus(GameStatus.FINISHED);
            return true;
        }
        return false;
    }

    public void checkForSnakesAndLadders(Game game) {
        int currentPosition = game.getPlayers().get(game.getCurrentPlayerIndex()).getPosition();
        if(game.getBoard().getSnakes().containsKey(currentPosition)) {
            int newPosition = game.getBoard().getSnakes().get(currentPosition);
            System.out.println("Oh no! " + game.getPlayers().get(game.getCurrentPlayerIndex()).getName() + " landed on a snake and slid down to position " + newPosition + ". \n");
            game.getPlayers().get(game.getCurrentPlayerIndex()).setPosition(newPosition);
        } else if(game.getBoard().getLadders().containsKey(currentPosition)) {
            int newPosition = game.getBoard().getLadders().get(currentPosition);
            System.out.println("Yay! " + game.getPlayers().get(game.getCurrentPlayerIndex()).getName() + " climbed a ladder to position " + newPosition + ". \n");
            game.getPlayers().get(game.getCurrentPlayerIndex()).setPosition(newPosition);
        }
    }
}
