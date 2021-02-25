package de.jonas.quiz;

import de.jonas.Quiz;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 500;

    private static final int QUESTION_LABEL_HEIGHT = 150;

    private static final int BUTTON_WIDTH = 350;
    private static final int BUTTON_HEIGHT = 130;

    private static final int CONTINE_BUTTON_WIDTH = 700;
    private static final int CONTINUE_BUTTON_HEIGHT = 50;

    private static final Font FONT = new Font("Arial", Font.BOLD, 25);

    private final Quiz quiz;

    private final String question;
    private final String solutionA;
    private final String solutionB;
    private final String solutionC;
    private final String solutionD;
    private final int correct;

    private final int currentRound;
    private final int overallRounds;

    private JFrame frame;

    private JButton solutionButtonA;
    private JButton solutionButtonB;
    private JButton solutionButtonC;
    private JButton solutionButtonD;
    private JButton continueButton;

    private boolean isCorrect;

    public GUI(
        @NotNull final String question,
        @NotNull final String solutionA,
        @NotNull final String solutionB,
        @NotNull final String solutionC,
        @NotNull final String solutionD,
        @Range(from = 1, to = 5) final int correct,
        @Range(from = 0, to = Integer.MAX_VALUE) final int currentRound,
        @Range(from = 0, to = Integer.MAX_VALUE) final int overallRounds
    ) {
        this.quiz = new Quiz();
        this.question = question;
        this.solutionA = solutionA;
        this.solutionB = solutionB;
        this.solutionC = solutionC;
        this.solutionD = solutionD;
        this.correct = correct;
        this.currentRound = currentRound;
        this.overallRounds = overallRounds;

        openFrame();
    }

    private void openFrame() {
        frame = new JFrame("Quiz -> Runde " + currentRound + " von " + overallRounds);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        JLabel questionLabel = new JLabel(question, JLabel.CENTER);
        questionLabel.setBounds(0, 0, FRAME_WIDTH, QUESTION_LABEL_HEIGHT);
        questionLabel.setOpaque(true);
        questionLabel.setBackground(Color.DARK_GRAY);
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(FONT);

        solutionButtonA = new JButton(solutionA);
        solutionButtonB = new JButton(solutionB);
        solutionButtonC = new JButton(solutionC);
        solutionButtonD = new JButton(solutionD);
        continueButton = new JButton("Weiter");

        solutionButtonA.setBounds(
            0,
            QUESTION_LABEL_HEIGHT,
            BUTTON_WIDTH,
            BUTTON_HEIGHT
        );
        solutionButtonB.setBounds(
            BUTTON_WIDTH,
            QUESTION_LABEL_HEIGHT,
            BUTTON_WIDTH,
            BUTTON_HEIGHT
        );
        solutionButtonC.setBounds(
            0,
            QUESTION_LABEL_HEIGHT + BUTTON_HEIGHT,
            BUTTON_WIDTH,
            BUTTON_HEIGHT
        );
        solutionButtonD.setBounds(
            BUTTON_WIDTH,
            QUESTION_LABEL_HEIGHT + BUTTON_HEIGHT,
            BUTTON_WIDTH,
            BUTTON_HEIGHT
        );
        continueButton.setBounds(
            0,
            QUESTION_LABEL_HEIGHT + BUTTON_HEIGHT * 2,
            CONTINE_BUTTON_WIDTH,
            CONTINUE_BUTTON_HEIGHT
        );

        configureButton(solutionButtonA);
        configureButton(solutionButtonB);
        configureButton(solutionButtonC);
        configureButton(solutionButtonD);

        continueButton.setOpaque(true);
        continueButton.setBackground(Color.YELLOW);
        continueButton.addActionListener(this);
        continueButton.setFont(FONT);

        frame.add(questionLabel);
        frame.add(solutionButtonA);
        frame.add(solutionButtonB);
        frame.add(solutionButtonC);
        frame.add(solutionButtonD);
        frame.add(continueButton);
        frame.setVisible(false);
    }

    public void close() {
        frame.dispose();
    }

    public void open() {
        frame.setVisible(true);
    }

    private boolean isAlreadySet() {
        return !(solutionButtonA.getBackground().equals(Color.LIGHT_GRAY)
            && solutionButtonB.getBackground().equals(Color.LIGHT_GRAY)
            && solutionButtonC.getBackground().equals(Color.LIGHT_GRAY)
            && solutionButtonD.getBackground().equals(Color.LIGHT_GRAY));
    }

    private void configureButton(@NotNull final JButton button) {
        button.setOpaque(true);
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(this);
        button.setFont(FONT);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (isAlreadySet()) {
            if (e.getSource().equals(continueButton)) {
                if (isCorrect) {
                    quiz.onCorrect();
                    return;
                }
                quiz.onFalse();
            }
            return;
        }
        if (e.getSource().equals(continueButton)) {
            return;
        }
        if (correct == 5) {
            ((JButton) e.getSource()).setBackground(Color.GREEN);
            isCorrect = true;
            return;
        }
        if (e.getSource().equals(solutionButtonA) && correct == 1) {
            solutionButtonA.setBackground(Color.GREEN);
            isCorrect = true;
            return;
        }
        if (e.getSource().equals(solutionButtonB) && correct == 2) {
            solutionButtonB.setBackground(Color.GREEN);
            isCorrect = true;
            return;
        }
        if (e.getSource().equals(solutionButtonC) && correct == 3) {
            solutionButtonC.setBackground(Color.GREEN);
            isCorrect = true;
            return;
        }
        if (e.getSource().equals(solutionButtonD) && correct == 4) {
            solutionButtonD.setBackground(Color.GREEN);
            isCorrect = true;
            return;
        }
        ((JButton) e.getSource()).setBackground(Color.RED);
        isCorrect = false;
    }
}
