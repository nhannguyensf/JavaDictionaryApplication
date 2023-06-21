import java.util.List;
import java.util.Scanner;

// Main class to run the interactive dictionary
public class Main {
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
            boolean doneCatching = false;
            switch (inputParts.length) {
                case 2:
                    for (EnumPartOfSpeech enumPartOfSpeech : EnumPartOfSpeech.values()) {
                        if (inputParts[1].equalsIgnoreCase(enumPartOfSpeech.getPartOfSpeech())) {
                            partOfSpeech = enumPartOfSpeech.getPartOfSpeech();
                            doneCatching = true;
                        } else if (inputParts[1].equalsIgnoreCase("distinct")) {
                            isDistinct = true;
                            doneCatching = true;
                        } else if (inputParts[1].equalsIgnoreCase("reverse")) {
                            isReverse = true;
                            doneCatching = true;
                        } else {
                            System.out.println(wrongParameter);
                        }
                        if (doneCatching) {
                            break;
                        }
                    }
                case 3:

                case 4:
                    for (EnumPartOfSpeech enumPartOfSpeech : EnumPartOfSpeech.values()) {
                        if (inputParts[1].equalsIgnoreCase(enumPartOfSpeech.getPartOfSpeech())) {
                            partOfSpeech = enumPartOfSpeech.getPartOfSpeech();
                            break;
                        }
                    }
                    if (inputParts[2].equalsIgnoreCase("distinct")) {
                        isDistinct = true;
                    }
                    if (inputParts[3].equalsIgnoreCase("reverse")) {
                        isReverse = true;
                    } else {
                        System.out.println(wrongParameter);
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