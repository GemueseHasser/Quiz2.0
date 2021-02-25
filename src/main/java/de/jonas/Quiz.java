package de.jonas;

import de.jonas.quiz.QuestionType;

import java.util.Arrays;

/**
 * Die Haupt- und Main-Klasse der Quiz-Anwendung. Von hieraus wird das Spiel beim öffnen initialisiert und gestartet.
 * Außerdem wird in dieser Klasse je nachdem ob eine Antwort richtig war oder nicht, diese gehandhabt.
 */
public class Quiz {

    //<editor-fold desc="CONSTANTS">
    /** Die Richtigkeit der Antowrten werden in diesem Array gespeichert. */
    private static final boolean[] ANSWERS = new boolean[QuestionType.values().length];
    /** Die individuellen {@link QuestionType Fragen} befinden sich in diesem Array. */
    private static final QuestionType[] QUESTIONS = QuestionType.values();
    //</editor-fold>


    //<editor-fold desc="STATIC-FIELDS">
    /** Die aktuelle Runden-Zahl. */
    private static int round;
    //</editor-fold>


    /**
     * Die Main-Methode, welche als erstes vor allen anderen Methoden aufgerufen wird und wodurch die Anwendung dann
     * gestartet wird.
     *
     * @param args .
     */
    public static void main(final String[] args) {
        QUESTIONS[round].getQuestion().open();
    }

    /**
     * Die Methode wird aufgerufen, sobald der Nutzer auf weiter geklickt hat, und seine abgegebene Antowrt richtig
     * war.
     */
    public void onCorrect() {
        ANSWERS[round] = true;
        QUESTIONS[round].getQuestion().close();
        round++;
        if (round >= QUESTIONS.length) {
            auswertung();
            return;
        }
        QUESTIONS[round].getQuestion().open();
    }

    /**
     * Die Methode wird aufgerufen, sobald der Nutzer auf weiter geklickt hat, und seine abgegebene Antowrt falsch war.
     */
    public void onFalse() {
        ANSWERS[round] = false;
        QUESTIONS[round].getQuestion().close();
        round++;
        if (round >= QUESTIONS.length) {
            auswertung();
            return;
        }
        QUESTIONS[round].getQuestion().open();
    }

    /**
     * Die Methode wird als aller letztes aufgerufen, wenn der Nutzer alle Fragen beantwortet hat. Hiermit wird das
     * Spiel dann ausgewertet und die grafische Übersicht der Fragen bzw dessen Riochtigkeit aufgerufen.
     */
    private void auswertung() {
        System.out.println("finish!");
        System.out.println("--------");
        System.out.println(Arrays.toString(ANSWERS));
        System.exit(0);
    }

}
