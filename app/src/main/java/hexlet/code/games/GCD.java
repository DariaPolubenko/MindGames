package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int NUMBER_OF_DIGITS = 2;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static String greeting = "Find the greatest common divisor of given numbers.";

    public static void playGCD() {

        String[] questions = new String[Engine.ROUNDS];
        String[] results = new String[Engine.ROUNDS];

        for (var i = 0; i < Engine.ROUNDS; i++) {
            int[] numbers = getNumbers();
            var firstNumber = numbers[0];
            var secondNumber = numbers[1];

            questions[i] = "Question: " + firstNumber + " " + secondNumber;

            var result = getResult(firstNumber, secondNumber);
            results[i] = String.valueOf(result);
        }
        Engine.getEngine(greeting, questions, results);
    }

    public static int[] getNumbers() {

        int[] numbers = new int[NUMBER_OF_DIGITS];
        do {
            numbers[0] = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER); // от [1 до 10]
            numbers[1] = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
        } while (numbers[0] == numbers[1]);

        int multiplier = Utils.getRandomInt(MIN_NUMBER + 1, MAX_NUMBER); // от [2 до 10]
        numbers[0] *= multiplier;
        numbers[1] *= multiplier;

        return numbers;
    }

    public static int getResult(int first, int second) {

        while (first != 0 && second != 0) {
            if (first > second) {
                first = first % second;
            } else {
                second = second % first;
            }
        }
        var result = first + second;
        return result;
    }

}
