import java.util.List;
import java.util.Scanner;

// Main class to run the interactive dictionary
public class Main {
    public void wrongParameterNotification(String position, String inputWord) {
        System.out.print("<The entered " + position + "parameter '" + inputWord + "' is NOT a part of speech.>");
    }

    public static void main(String[] args) {
        InteractiveDictionary dictionary = new InteractiveDictionary();
        Scanner scanner = new Scanner(System.in);
        String helpMessage = ("|\n PARAMETER HOW-TO, please enter:\n" +
                "1. A search key -then 2. An optional part of speech -then\n" +
                "3. An optional 'distinct' -then 4. An optional 'reverse'\n|");
        String wrongParameter = ("|\n" +
                "<The entered 2nd parameter 'ok' is NOT a part of speech.>\n" +
                "<The entered 2nd parameter 'ok' is NOT 'distinct'.>\n" +
                "<The entered 2nd parameter 'ok' is NOT 'reverse'.>\n" +
                "<The entered 2nd parameter 'ok' was disregarded.>\n" +
                "<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>\n" +
                "|");
        String partOfSpeech = null;
        boolean isDistinct = false;
        boolean isReverse = false;

        int searchCount = 1;
        while (true) {
            System.out.print("Search [" + searchCount + "]: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("!q")) {
                System.out.println("----- THANK YOU -----");
                break;
            }
            String[] inputParts = userInput.split("\\s+");
            if ((userInput.equalsIgnoreCase("!help")) || (userInput.matches("\\s*|\\u0000")) || (inputParts.length > 4)) {
                System.out.println(helpMessage);
                searchCount++;
                continue;
            }

            String searchKey = inputParts[0];

            if (inputParts.length >= 2) {
                for (EnumPartOfSpeech enumPartOfSpeech : EnumPartOfSpeech.values()) {
                    if (inputParts[1].equalsIgnoreCase(enumPartOfSpeech.getPartOfSpeech())) {
                        partOfSpeech = enumPartOfSpeech.getPartOfSpeech();
                        break;
                    }
                }
                isDistinct = inputParts[1].equalsIgnoreCase("distinct");
                isReverse = inputParts[1].equalsIgnoreCase("reverse");
                if ((partOfSpeech == null) && (!isDistinct) && (!isReverse)) {
                    System.out.println("|\n" +
                            "<The entered 2nd parameter 'ok' is NOT a part of speech.>\n" +
                            "<The entered 2nd parameter 'ok' is NOT 'distinct'.>\n" +
                            "<The entered 2nd parameter 'ok' is NOT 'reverse'.>\n" +
                            "<The entered 2nd parameter 'ok' was disregarded.>\n" +
                            "<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>\n" +
                            "|");
                }
            }
            if (inputParts.length >= 3) {
                if (!isDistinct) {
                    isDistinct = inputParts[2].equalsIgnoreCase("distinct");
                }
                if (!isReverse) {
                    isReverse = inputParts[2].equalsIgnoreCase("reverse");
                }
                if ((!inputParts[2].equalsIgnoreCase("distinct")) && (!inputParts[2].equalsIgnoreCase("reverse"))) {
                    System.out.println("|\n" +
                            "<The entered 3nd parameter 'ok' is NOT 'distinct'.>\n" +
                            "<The entered 3nd parameter 'ok' is NOT 'reverse'.>\n" +
                            "<The entered 3nd parameter 'ok' was disregarded.>\n" +
                            "<The 3nd parameter should be 'distinct' or 'reverse'.>\n" +
                            "|");
                }
            }
            if (inputParts.length == 4) {
                if (!isReverse) {
                    isReverse = inputParts[3].equalsIgnoreCase("reverse");
                }
                if (!(inputParts[3].equalsIgnoreCase("reverse"))) {
                    System.out.println("|\n" +
                            "<The entered 4nd parameter 'ok' is NOT 'reverse'.>\n" +
                            "<The entered 4nd parameter 'ok' was disregarded.>\n" +
                            "<The 4nd parameter should be 'reverse'.>\n" +
                            "|");
                }
            }

            List<String> matchingEntries = dictionary.search(searchKey, partOfSpeech, isDistinct, isReverse);
            dictionary.displayResults(matchingEntries);
            searchCount++;
            partOfSpeech = null;
            isDistinct = false;
            isReverse = false;
        }
        scanner.close();
    }
}

