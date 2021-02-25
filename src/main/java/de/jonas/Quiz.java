package de.jonas;

import de.jonas.quiz.Questions;

import java.util.Arrays;

public class Quiz {

    private static final boolean[] ANSWERS = new boolean[Questions.values().length];

    private static final Questions[] questions = Questions.values();

    private static int round;

    public static void main(final String[] args) {
        questions[round].getQuestion().open();
    }

    public void onCorrect() {
        ANSWERS[round] = true;
        questions[round].getQuestion().close();
        round++;
        if (round >= questions.length) {
            auswertung();
            return;
        }
        questions[round].getQuestion().open();
    }

    public void onFalse() {
        ANSWERS[round] = false;
        questions[round].getQuestion().close();
        round++;
        if (round >= questions.length) {
            auswertung();
            return;
        }
        questions[round].getQuestion().open();
    }

    private void auswertung() {
        System.out.println("finish!");
        System.out.println("--------");
        System.out.println(Arrays.toString(ANSWERS));
        System.exit(0);
    }

}
