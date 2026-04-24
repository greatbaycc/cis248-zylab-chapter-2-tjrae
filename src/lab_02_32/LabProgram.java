package lab_02_32;

import java.util.Arrays;
import java.util.Scanner;

public class LabProgram {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] diceValues = new int[5];
        int highScore = 0;

        // Fill array with five values from input
        for (int i = 0; i < diceValues.length; ++i) {
            diceValues[i] = scnr.nextInt();
        }

        // Place values in ascending order
        Arrays.sort(diceValues);

        // Find high score and output
        highScore = findHighScore(diceValues);
        System.out.println("High score: " + highScore);
    }

    // Find high score
    public static int findHighScore(int[] dice) {
        int score = 0;
        int highScore = 0;
        score = checkThreeOfKind(dice);
        if (score > highScore) {
            highScore = score;
        }
        score = checkFourOfKind(dice);
        if (score > highScore) {
            highScore = score;
        }
        score = checkFiveOfKind(dice);
        if (score > highScore) {
            highScore = score;
        }
        score = checkFullHouse(dice);
        if (score > highScore) {
            highScore = score;
        }
        for (int i = 1; i < dice.length - 1; ++i) {
            score = checkSingles(dice, i);
            if (score > highScore) {
                highScore = score;
            }
        }
        score = checkStraight(dice);
        if (score > highScore) {
            highScore = score;
        }
        return highScore;
    }

    // Add all occurrences of goal value
    public static int checkSingles(int[] dice, int goal) {
        int score = 0;

        for (int die : dice) {
            if (die == goal) {
                score += goal;
            }
        }

        return score;
    }

    // Check for three of a kind (score = 30)
    public static int checkThreeOfKind(int[] dice) {
        int score = 0;
        if (dice[0] == dice[2] || dice[1] == dice[2] || dice[2] == dice[4]) {
            score = 30;
        }
        return score;
    }

    // Check for four of a kind (score = 40)
    public static int checkFourOfKind(int[] dice) {
        int score = 0;
        if (dice[0] == dice[3] || dice[1] == dice[4]) {
            score = 40;
        }
        return score;
    }

    // Check for five of a kind (score = 50)
    public static int checkFiveOfKind(int[] dice) {
        int score = 0;
        if (dice[0] == dice[4]) {
            score = 50;
        }
        return score;
    }

    // Check for full house (score = 35)
    public static int checkFullHouse(int[] dice) {
        int score = 0;
        if (dice[0] == dice[1] && dice[2] == dice[4]) {
            score = 35;
        }
        if (dice[0] == dice[2] && dice[3] == dice[4]) {
            score = 35;
        }
        return score;
    }

    // Check for straight (score = 45)
    public static int checkStraight(int[] dice) {
        int score = 45;
        for (int i = 0; i < dice.length - 1; ++i) {
            if (dice[i] + 1 != dice[i + 1]) {
                return 0;
            }
        }
        return score;
    }
}
