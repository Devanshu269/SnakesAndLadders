package model;

import enums.PlayerType;

public class Player {
    private String name;
    private PlayerType playerType;
    private int position;

    public Player(String name, PlayerType playerType, int position) {
        this.name = name;
        this.playerType = playerType;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
