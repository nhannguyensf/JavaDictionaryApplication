import java.util.List;
import java.util.Scanner;

// Main class to run the interactive dictionary
public class Main {
    public static void main(String[] args) {
        InteractiveDictionary dictionary = new InteractiveDictionary();
        Scanner scanner = new Scanner(System.in);

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
            if ((userInput.equals("!help")) || (userInput.matches("\\s*|\\u0000"))) {
                System.out.println("|\n PARAMETER HOW-TO, please enter:\n" +
                        "1. A search key -then 2. An optional part of speech -then\n" +
                        "3. An optional 'distinct' -then 4. An optional 'reverse'\n|");
                searchCount++;
                continue;
            }

            String[] inputParts = userInput.split("\\s+");
            String searchKey = inputParts[0];
            switch (inputParts.length) {
                case 2:
                        for (EnumPartOfSpeech enumPartOfSpeech : EnumPartOfSpeech.values()) {
                            if (inputParts[1].equalsIgnoreCase(enumPartOfSpeech.getPartOfSpeech())) {
                                partOfSpeech = enumPartOfSpeech.getPartOfSpeech();
                            } else if (inputParts[1].equalsIgnoreCase("distinct")) {
                                isDistinct = true;
                            } else if (inputParts[1].equalsIgnoreCase("reverse")) {
                                isReverse = true;
                            }
                        }
                    }
                case 3:
                    for (EnumPartOfSpeech enumPartOfSpeech : EnumPartOfSpeech.values()) {
                        if (inputParts[1].equalsIgnoreCase(enumPartOfSpeech.getPartOfSpeech())) {
                            partOfSpeech = enumPartOfSpeech.getPartOfSpeech();
                        } else if (inputParts[1].equalsIgnoreCase("distinct")) {
                            isDistinct = true;
                        } else if (inputParts[1].equalsIgnoreCase("reverse")) {
                            isReverse = true;
                        }
                    }

                case 4:
            }
            partOfSpeech = inputParts.length > 1 ? inputParts[1] : null;
            if (inputParts.length > 1) {
                for (EnumPartOfSpeech enumPartOfSpeech : EnumPartOfSpeech.values()) {
                    if (inputParts[1].equalsIgnoreCase(enumPartOfSpeech.getPartOfSpeech())) {
                        partOfSpeech = enumPartOfSpeech.getPartOfSpeech();
                        if (inputParts[2].equalsIgnoreCase("distinct")) {
                            isDistinct = true;
                        }
                        isReverse = inputParts[2].equalsIgnoreCase("reverse");

                        break;
                    } else if (inputParts[1].equalsIgnoreCase("distinct"))
                        isDistinct = true;
                }

                isReverse = inputParts[2].equalsIgnoreCase("reverse");
            List<EnumDictionaryData> matchingEntries = dictionary.search(searchKey, partOfSpeech, isDistinct, isReverse);
            dictionary.displayResults(matchingEntries);
            searchCount++;
            }
        }

        scanner.close();
    }
}
