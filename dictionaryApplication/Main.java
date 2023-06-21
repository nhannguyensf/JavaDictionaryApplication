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

        int searchCount = 1;
        while (true) {
            String partOfSpeech=null;
            boolean isDistinct=false;
            boolean isReverse=false;

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
//            String partOfSpeech = inputParts.length > 1 ? inputParts[1] : null;
//            boolean foundPartOfSpeech = false;
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
                case 3:

                case 4:
            }


            List<String> matchingEntries = dictionary.search(searchKey, partOfSpeech, isDistinct, isReverse);
            dictionary.displayResults(matchingEntries);
            searchCount++;
        }

        scanner.close();
    }
}
