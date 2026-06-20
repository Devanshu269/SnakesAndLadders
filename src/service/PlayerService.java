package service;

import enums.GameStatus;
import model.Dice;
import model.Game;
import model.Player;

public class PlayerService {

    public void takeTurn(Game game, Player player) {
        System.out.println(player.getName() + " is taking their turn. \n");
        Dice dice = game.getDice();

        int move = dice.roll();
        System.out.println(player.getName() + " rolled a " + move + ". \n");
        if (player.getPosition() + move > game.getBoard().getSize()) {
            System.out.println(player.getName() + " cross the Board size will remain at Same place! \n");
        } else {
            player.setPosition(player.getPosition() + move);
            System.out.println(player.getName() + " moved to position " + player.getPosition() + ". \n");
        }
    }
}
