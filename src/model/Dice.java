package model;

import java.util.Random;

public class Dice {
    private static int minValueOfFace = 1;
    private int numberOfDice;
    private int numberOfFaces;
    Random random = new Random();

    public Dice(int numberOfDice, int numberOfFaces) {
        this.numberOfDice = numberOfDice;
        this.numberOfFaces = numberOfFaces;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int  roll() {
        int total = 0;
        for (int i = 0; i < this.numberOfDice; i++) {
            total += random.nextInt((this.numberOfFaces - minValueOfFace) + 1) + minValueOfFace;
        }
        return total;
    }
}
