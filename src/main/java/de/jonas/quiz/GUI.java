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

/**
 * Ein {@link GUI Graphical-User-Interface} wird für jede Frage einzeln und individuell instanziiert.
 */
public class GUI implements ActionListener {

    //<editor-fold desc="CONSTANTS">
    /** Die Breite des {@link JFrame Fensters}. */
    private static final int FRAME_WIDTH = 700;
    /** Die Höhe des {@link JFrame Fensters}. */
    private static final int FRAME_HEIGHT = 500;

    /** Die Höhe des {@link JLabel Schriftzugs} womit die Frage angezeigt wird. */
    private static final int QUESTION_LABEL_HEIGHT = 150;

    /** Die Breite eines jeden {@link JButton Buttons} für das Angeben der Antworten. */
    private static final int BUTTON_WIDTH = 350;
    /** Die Höhe eines jeden {@link JButton Buttons} für das Angeben der Antworten. */
    private static final int BUTTON_HEIGHT = 130;

    /** Die Breite des {@link JButton Button}, womit man zur nächsten Frage kommt. */
    private static final int CONTINE_BUTTON_WIDTH = 700;
    /** Die Höhe des {@link JButton Button}, womit man zur nächsten Frage kommt. */
    private static final int CONTINUE_BUTTON_HEIGHT = 50;

    /** Die {@link Font Schriftart}, die für alle Texte in der Anwendung angewendet wird. */
    private static final Font FONT = new Font("Arial", Font.BOLD, 25);
    //</editor-fold>


    //<editor-fold desc="LOCAL-FIELDS">
    /** Das {@link Quiz} für jede Runde. */
    private final Quiz quiz;

    /** Die jeweilige Frage. */
    private final String question;
    /** Die erste Antwort von insgesamt vier. */
    private final String solutionA;
    /** Die zweite Antwort von insgesamt vier. */
    private final String solutionB;
    /** Die dritte Antwort von insgesamt vier. */
    private final String solutionC;
    /** Die vierte Antwort von insgesamt vier. */
    private final String solutionD;
    /** Die Nummer der richtigen Antwort. */
    private final int correct;

    /** Die Nummer, der aktuellen Runde. */
    private final int currentRound;
    /** Die Anzahl an Runden, die es insgesamt gibt. */
    private final int overallRounds;

    /** Das {@link JFrame Fenster}, welches das {@link GUI} ausmacht. */
    private JFrame frame;

    /** Der {@link JButton Button}, wodurch man die erste mögliche Antwort bestätigt. */
    private JButton solutionButtonA;
    /** Der {@link JButton Button}, wodurch man die zweite mögliche Antwort bestätigt. */
    private JButton solutionButtonB;
    /** Der {@link JButton Button}, wodurch man die dritte mögliche Antwort bestätigt. */
    private JButton solutionButtonC;
    /** Der {@link JButton Button}, wodurch man die vierte mögliche Antwort bestätigt. */
    private JButton solutionButtonD;
    /**
     * Der {@link JButton Button}, womit man in die nächste Runde gehen kann, nachdem man eine Auswahl getroffen hat.
     */
    private JButton continueButton;

    /** Die Richtigkeit der angegebenen Antowrt. */
    private boolean isCorrect;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erstellt eine neue und vollständig unabhängiges Instanz des {@link GUI Graphical-User-Interface}, womit die
     * einzelnen Fragen visualisiert werden und das Antworten des Nutzers gehandhabt wird.
     *
     * @param question      Die Frage, die dem Nutzer angezeigt wird.
     * @param solutionA     Die erste mögliche Antwort, die dem Nutzer angezeigt wird.
     * @param solutionB     Die zweite mögliche Antwort, die dem Nutzer angezeigt wird.
     * @param solutionC     Die dritte mögliche Antwort, die dem Nutzer angezeigt wird.
     * @param solutionD     Die vierte mögliche Antwort, die dem Nutzer angezeigt wird.
     * @param correct       Die Nummer der richtigen Antwort.
     * @param currentRound  Die Nummer der aktuellen Runde.
     * @param overallRounds Die Anzahl an Runden, die es insgesamt gibt.
     */
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
    //</editor-fold>


    /**
     * Öffnet dem Nutzer das {@link JFrame Fenster}, worauf er die Fragen mit den jeweiligen Antworten angezeigt bekommt
     * und die seines erachtens richtige Antwort wählen kann.
     */
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

    /**
     * Das {@link JFrame Fenster} schließen.
     */
    public void close() {
        frame.dispose();
    }

    /**
     * Das {@link JFrame Fenster} öffnen.
     */
    public void open() {
        frame.setVisible(true);
    }

    /**
     * Es wird abgefragt, ob der Nutzer schon eine Antwort gegeben hat.
     *
     * @return Hat der Nutzer schon eine Antwort gegeben oder nicht.
     */
    private boolean isAlreadySet() {
        return !(solutionButtonA.getBackground().equals(Color.LIGHT_GRAY)
            && solutionButtonB.getBackground().equals(Color.LIGHT_GRAY)
            && solutionButtonC.getBackground().equals(Color.LIGHT_GRAY)
            && solutionButtonD.getBackground().equals(Color.LIGHT_GRAY));
    }

    /**
     * Konfiguriert einen {@link JButton Button} so, sodass er gut aussieht.
     *
     * @param button Der {@link JButton Button}, der konfiguriert wird.
     */
    private void configureButton(@NotNull final JButton button) {
        button.setOpaque(true);
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(this);
        button.setFont(FONT);
    }

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
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
