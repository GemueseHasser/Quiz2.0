package de.jonas.quiz;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * Die einzelnen Frage-Typen werden hier konfiguriert bzw instanziiert.
 */
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public enum QuestionType {

    /** Die erste {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    ONE(
        "In welchem Jahr ist die Titanic am 15. April auf ihrer Jungfernfahrt von "
            + "Southampton im Atlantik gesunken?",
        "1915",
        "1912",
        "1875",
        "1921",
        2,
        1
    ),
    /** Die zweite {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    TWO(
        "Wie lautet der Titel des ersten Carry-On-Films, der 1958 gedreht und veröffentlicht wurde?",
        "Trage Sergeant",
        "Afghan Breakdown",
        "Abschiedsdisco",
        "Abschied und Hoffnung",
        1,
        2
    ),
    /** Die dritte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    THREE(
        "Wie heißt das größte Technologieunternehmen in Südkorea?",
        "Posco",
        "Hyundai",
        "Huawei",
        "Samsung",
        4,
        3
    ),
    /** Die vierte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    FOUR(
        "Welcher Sänger stand der Popgruppe Showaddywaddy der 1970er Jahre gegenüber?",
        "Michael Jackson",
        "Dave Bartram",
        "Freddie Mercury",
        "David Bowie",
        2,
        4
    ),
    /** Die fünfte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    FIVE(
        "Welcher mittlerweile berühmte Fernsehkoch begann im Alter von acht Jahren in der "
            + "Kneipe seiner Eltern, 'The Cricketers', in Clavering, Essex, mit dem Kochen?",
        "Frank Buchholz",
        "Alfred Biolek",
        "Jamie Oliver",
        "Hans Karl Adam",
        3,
        5
    ),
    /**
     * Die sechste {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist.
     */
    SIX(
        "Welcher niederländische Dartspieler hat am 15. Januar 2012 die BDO-Weltmeisterschaft im "
            + "Lakeside Country Club, Frimley Green, gewonnen?",
        "Jelle Klaasen",
        "Christian Kist",
        "Roland Scholten",
        "Derk Telnekes",
        2,
        6
    ),
    /** Die siebte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    SEVEN(
        "Welches Metall wurde 1825 von Hans Christian Oersted entdeckt?",
        "Gold",
        "Magnesium",
        "Aluminium",
        "Kupfer",
        3,
        7
    ),
    /** Die achte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    EIGHT(
        "Was ist die Hauptstadt von Portugal?",
        "Sintra",
        "Lissabon",
        "Faro",
        "Porto",
        2,
        8
    ),
    /** Die neunte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    NINE(
        "Wie viele Atemzüge nimmt der menschliche Körper täglich ca?",
        "20.000",
        "15.000",
        "17.000",
        "30.000",
        1,
        9
    ),
    /** Die zehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    TEN(
        "Wer war von 1841 bis 1846 Premierminister von Großbritannien?",
        "Lord John Russell",
        "Henry Pelham",
        "Sir Robert Walpole",
        "Sir Robert Peel",
        4,
        10
    ),
    /** Die elfte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
    ELEVEN(
        "Was ist das chemische Symbol für Silber?",
        "Fe",
        "La",
        "Ag",
        "Ar",
        3,
        11
    ),
    /**
     * Die zwölfte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist.
     */
    TWELFE(
        "Wer hat 1934 Cat's Eyes erfunden, um die Verkehrssicherheit zu verbessern?",
        "Hermann Anschütz-Kaempfe",
        "Percy Shaw",
        "Hal Anger",
        "Mary Anderson",
        2,
        12
    ),
    /**
     * Die dreizehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    THIRTEEN(
        "Was ist der kleinste Vogel der Welt?",
        "Adlerkolibri",
        "Meise",
        "Adler",
        "Bienen-Kolibri",
        4,
        13
    ),
    /**
     * Die vierzehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    FOURTEEN(
        "Wer hat 'Bodie' und 'Doyle' in The Professionals gespielt?",
        "Lewis Collins und Martin Shaw",
        "Lee Marvin und Gregory Walcott",
        "Janit Baldwin und Clint Ellison",
        "Maximilian Grill und Henning Baum",
        1,
        14
    ),
    /**
     * Die fünfzehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    FIVETEEN(
        "Wofür hält Paul Hunn den Rekord, der bei 118.1 Dezibel lag?",
        "Der lauteste Schrei",
        "Das lauteste Trampeln",
        "Das lauteste Rülpsen",
        "Das lauteste Klatschen",
        3,
        15
    ),
    /**
     * Die sechzehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    SIXTEEN(
        "Was ist die Lebensdauer einer Libelle?",
        "7 Tage",
        "24 Stunden",
        "1 Monat",
        "2 Tage",
        2,
        16
    ),
    /**
     * Die siebzehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    SEVENTEEN(
        "In welchem Jahr wurde der erste Tonka-Truck hergestellt?",
        "1947",
        "1945",
        "1949",
        "1950",
        1,
        17

    ),
    /**
     * Die achtezhnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    EIGHTEEN(
        "Wer hat 1810 die Blechdose zur Konservierung von Lebensmitteln erfunden?",
        "Al-Chwarizmi",
        "Archimedes",
        "George Antheil",
        "Peter Durand",
        4,
        18
    ),
    /**
     * Die neunzehnte {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    NINETEEN(
        "Wie viele Weihnachtsbäume werden in Deutschland pro Jahr ca verkauft?",
        "10 Mio",
        "15 Mio",
        "30 Mio",
        "40 Mio",
        3,
        19
    ),
    /**
     * Die zwanzigste {@link QuestionType Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig
     * ist.
     */
    TWENTY(
        "Welche 2 Serien sind die besten?",
        "Das A-Team und Der letzte Bulle",
        "Das A-Team und Der letzte Bulle",
        "Das A-Team und Der letzte Bulle",
        "Das A-Team und Der letzte Bulle",
        5,
        20
    );


    //<editor-fold desc="CONSTANTS">
    /** Die insgesamte Anzahl an Runden, die es in diesem Spiel gibt. */
    private static final int OVERALL_ROUNDS = 20;
    //</editor-fold>


    //<editor-fold desc="LOCAL-FIELDS">
    /**
     * das individuelle {@link GUI Fenster} zu der {@link QuestionType Frage}. Also die fertige Frage in einem Fenster.
     */
    @Getter
    private final GUI question;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erstellt eine neue und vollständig unabhängige Instanz des {@link QuestionType Fragen-Typs}. Aus einer Frage,
     * vier Antworten und die Angabe der richtigen Frage, wird ein {@link GUI Graphical-User-Interface} gebaut, womit
     * der Nutzer dann interagieren kann und die entsprechende Frage wählen kann.
     *
     * @param question     Die Frage, die das {@link GUI} leitet.
     * @param solutionA    Die erste mögliche Antwort.
     * @param solutionB    Die zweite mögliche Antwort.
     * @param solutionC    Die dritte mögliche Antwort.
     * @param solutionD    Die vierte mögliche Antwort.
     * @param correct      Die Angabe der richtigen Antwort.
     * @param currentRound Die Nummer der aktuellen Runde.
     */
    QuestionType(
        @NotNull final String question,
        @NotNull final String solutionA,
        @NotNull final String solutionB,
        @NotNull final String solutionC,
        @NotNull final String solutionD,
        @Range(from = 1, to = 5) final int correct,
        @Range(from = 0, to = Integer.MAX_VALUE) final int currentRound
    ) {
        this.question = new GUI(
            "<html>" + question + "</html>",
            "<html>" + solutionA + "</html>",
            "<html>" + solutionB + "</html>",
            "<html>" + solutionC + "</html>",
            "<html>" + solutionD + "</html>",
            correct,
            currentRound,
            OVERALL_ROUNDS
        );
    }
    //</editor-fold>

}
