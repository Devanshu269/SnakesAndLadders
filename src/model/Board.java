package model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;
    private int numberOfSnakes;
    private int numberOfLadders;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    public Board(int size, int numberOfSnakes, int numberOfLadders) {
        this.size = size;
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;
        setRandomSnakes(size, numberOfSnakes);
        setRandomLadders(size, numberOfLadders);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    private void setRandomSnakes(int boardSize, int numberOfSnakes) {
        Map<Integer, Integer> snakesTemp = new HashMap<>();
        for (int i = 0; i < numberOfSnakes; i++) {
            int head = (int) (Math.random() * (boardSize - 1)) + 2;
            int tail = (int) (Math.random() * (head - 1)) + 1;
            snakesTemp.put(head, tail);
        }
        this.snakes = snakesTemp;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    private void setRandomLadders(int boardSize, int numberOfLadders) {
        Map<Integer, Integer> laddersTemp = new HashMap<>();
        for (int i = 0; i < numberOfLadders; i++) {
            int bottom = (int) (Math.random() * (boardSize - 1)) + 1;
            int top = (int) (Math.random() * (boardSize - bottom)) + bottom + 1;
            laddersTemp.put(bottom, top);
        }
        this.ladders = laddersTemp;
    }
}