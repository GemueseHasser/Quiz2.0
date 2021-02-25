package de.jonas.quiz;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public enum Questions {

    /** Die erste {@link Questions Frage}, mit seinen vier vorgeschlagenen Antworten, von denen eine richtig ist. */
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
    TWO(
        "Wie lautet der Titel des ersten Carry-On-Films, der 1958 gedreht und veröffentlicht wurde?",
        "Trage Sergeant",
        "Afghan Breakdown",
        "Abschiedsdisco",
        "Abschied und Hoffnung",
        1,
        2
    ),
    THREE(
        "Wie heißt das größte Technologieunternehmen in Südkorea?",
        "Posco",
        "Hyundai",
        "Huawei",
        "Samsung",
        4,
        3
    ),
    FOUR(
        "Welcher Sänger stand der Popgruppe Showaddywaddy der 1970er Jahre gegenüber?",
        "Michael Jackson",
        "Dave Bartram",
        "Freddie Mercury",
        "David Bowie",
        2,
        4
    ),
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
    SIX(
        "Welcher niederländische Dartspieler hat am 2012. Januar die BDO-Weltmeisterschaft 15 im "
            + "Lakeside Country Club, Frimley Green, gewonnen?",
        "Jelle Klaasen",
        "Christian Kist",
        "Roland Scholten",
        "Derk Telnekes",
        2,
        6
    ),
    SEVEN(
        "Welches Metall wurde 1825 von Hans Christian Oersted entdeckt?",
        "Gold",
        "Magnesium",
        "Aluminium",
        "Kupfer",
        3,
        7
    ),
    EIGHT(
        "Was ist die Hauptstadt von Portugal?",
        "Sintra",
        "Lissabon",
        "Faro",
        "Porto",
        2,
        8
    ),
    NINE(
        "Wie viele Atemzüge nimmt der menschliche Körper täglich ca?",
        "20.000",
        "15.000",
        "17.000",
        "30.000",
        1,
        9
    ),
    TEN(
        "Wer war von 1841 bis 1846 Premierminister von Großbritannien?",
        "Lord John Russell",
        "Henry Pelham",
        "Sir Robert Walpole",
        "Sir Robert Peel",
        4,
        10
    ),
    ELEVEN(
        "Was ist das chemische Symbol für Silber?",
        "Fe",
        "La",
        "Ag",
        "Ar",
        3,
        11
    ),
    TWELFE(
        "Wer hat 1934 Cat's Eyes erfunden, um die Verkehrssicherheit zu verbessern?",
        "Hermann Anschütz-Kaempfe",
        "Percy Shaw",
        "Hal Anger",
        "Mary Anderson",
        2,
        12
    ),
    THIRTEEN(
        "Was ist der kleinste Vogel der Welt?",
        "Adlerkolibri",
        "Meise",
        "Adler",
        "Bienen-Kolibri",
        4,
        13
    ),
    FOURTEEN(
        "Wer hat 'Bodie' und 'Doyle' in The Professionals gespielt?",
        "Lewis Collins und Martin Shaw",
        "Lee Marvin und Gregory Walcott",
        "Janit Baldwin und Clint Ellison",
        "Maximilian Grill und Henning Baum",
        1,
        14
    ),
    FIVETEEN(
        "Wofür hält Paul Hunn den Rekord, der bei 118.1 Dezibel lag?",
        "Der lauteste Schrei",
        "Das lauteste Trampeln",
        "Das lauteste Rülpsen",
        "Das lauteste Klatschen",
        3,
        15
    ),
    SIXTEEN(
        "Was ist die Lebensdauer einer Libelle?",
        "7 Tage",
        "24 Stunden",
        "1 Monat",
        "2 Tage",
        2,
        16
    ),
    SEVENTEEN(
        "In welchem Jahr wurde der erste Tonka-Truck hergestellt?",
        "1947",
        "1945",
        "1949",
        "1950",
        1,
        17

    ),
    EIGHTEEN(
        "Wer hat 1810 die Blechdose zur Konservierung von Lebensmitteln erfunden?",
        "Al-Chwarizmi",
        "Archimedes",
        "George Antheil",
        "Peter Durand",
        4,
        18
    ),
    NINETEEN(
        "Wie viele Weihnachtsbäume werden in Deutschland pro Jahr ca verkauft?",
        "10 Mio",
        "15 Mio",
        "30 Mio",
        "40 Mio",
        3,
        19
    ),
    TWENTY(
        "Welche 2 Serien sind die besten?",
        "Das A-Team und Der letzte Bulle",
        "Das A-Team und Der letzte Bulle",
        "Das A-Team und Der letzte Bulle",
        "Das A-Team und Der letzte Bulle",
        5,
        20
    );

    @Getter
    private final GUI question;

    Questions(
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
            solutionA,
            solutionB,
            solutionC,
            solutionD,
            correct,
            currentRound,
            20
        );
    }

}
