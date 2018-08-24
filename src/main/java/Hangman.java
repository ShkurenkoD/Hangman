import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    private String mysteryWord;
    private StringBuilder currentGuess;
    ArrayList<Character> prevGuesses = new ArrayList<>();

    int maxTries = 6;
    private int currentTry = 0;

    final ArrayList<String> dictionaryWords = new ArrayList<>(30_000);

    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public Hangman() throws IOException {
        initializeStreams();
        mysteryWord = pickWord();
        currentGuess = initializeCurrentGuess();
    }

    private StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length() * 2; i++) {
            if (i % 2 == 0){
                current.append("_");
            } else
            current.append(" ");
        }
        return current;
    }

    private String pickWord() {
        Random random = new Random();
        int indexWord = random.nextInt(dictionaryWords.size());
        return dictionaryWords.get(indexWord);
    }

    private void initializeStreams() throws IOException{
        try{
            File inFile = new File("/home/topper/IdeaProjects/Hangman/src/main/resources/hangman words");
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line!=null){
                dictionaryWords.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e){
            System.out.println("Could not init streams");
        }
    }

    public String drawPicture() {
        switch (currentTry){
            case 0 : return noPersondDraw();
            case 1 : return addHeadDraw();
            case 2 : return addBodyDraw();
            case 3 : return addOneHandDraw();
            case 4 : return addSecondHandDraw();
            case 5 : return addOneLegDraw();
            default: return fullPersonDraw();

        }
    }

    private String noPersondDraw() {
        return " - - - - -\n"+
                "|        \n"+
                "|        \n" +
                "|        \n"+
                "|        \n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        \n"+
                "|        \n" +
                "|         \n" +
                "|\n" +
                "|\n";

    }

    private String addBodyDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        |  \n"+
                "|        \n" +
                "|        \n" +
                "|\n" +
                "|\n";

    }

    private String addOneHandDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / |  \n"+
                "|        \n" +
                "|        \n" +
                "|\n" +
                "|\n";

    }

    private String addSecondHandDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";

    }

    private String addOneLegDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       /  \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";

    }

    public String getFormalCurrentGuess(){
        return "Current Quess:" + currentGuess.toString();
    }

    public static void main(String[] args) {

        try {
            Hangman hangman = new Hangman();
            hangman.initializeCurrentGuess();
            System.out.println(hangman.noPersondDraw());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
