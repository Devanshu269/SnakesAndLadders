package model;


import enums.GameStatus;

import java.util.List;

public class Game {
    public Board board;
    public List<Player> players;
    public Dice dice;
    public GameStatus gameStatus;
    public int currentPlayerIndex;

    public Game(Board board, List<Player> players, Dice dice, GameStatus gameStatus, int currentPlayerIndex) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.gameStatus = gameStatus;
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }
}