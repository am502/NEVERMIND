package ru.itis.letter;

public class Application {
    public static void main(String[] args) {
        Parameters.setPixelSize(3);
        Parameters.setLetterGap(2);

        String text = "Far concluded not his something extremity. Want four we face an he gate. On he of played " +
                "he ladies answer little though nature. Blessing oh do pleasure as so formerly. " +
                "Took four spot soon led size you. Outlived it received he material. " +
                "Him yourself joy moderate off repeated laughter outweigh screened.";

        for (String line : TextProcessor.process(text.toLowerCase(), 15)) {
            System.out.println("[" + line + "]");
        }
    }
}
