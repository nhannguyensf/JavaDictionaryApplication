import java.util.*;

// Interactive dictionary class
public class InteractiveDictionary {
    private final Map<String, List<EnumDictionaryData>> dictionary;
    private static final String helpMessage = ("""
            |
             PARAMETER HOW-TO, please enter:
            1. A search key -then 2. An optional part of speech -then
            3. An optional 'distinct' -then 4. An optional 'reverse'
            |""");

    public static void runDictionary() {
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
                    System.out.printf("""
                            |
                            <The entered 2nd parameter '%s' is NOT a part of speech.>
                            <The entered 2nd parameter '%s' is NOT 'distinct'.>
                            <The entered 2nd parameter '%s' is NOT 'reverse'.>
                            <The entered 2nd parameter '%s' was disregarded.>
                            <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>
                            |
                            """, inputParts[1], inputParts[1], inputParts[1], inputParts[1]);
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
                    System.out.printf("""
                            |
                            <The entered 3rd parameter '%s' is NOT 'distinct'.>
                            <The entered 3rd parameter '%s' is NOT 'reverse'.>
                            <The entered 3rd parameter '%s' was disregarded.>
                            <The 3rd parameter should be 'distinct' or 'reverse'.>
                            |
                            """, inputParts[2], inputParts[2], inputParts[2]);
                }
            }
            if (inputParts.length == 4) {
                if (!isReverse) {
                    isReverse = inputParts[3].equalsIgnoreCase("reverse");
                }
                if (!(inputParts[3].equalsIgnoreCase("reverse"))) {
                    System.out.printf("""
                            |
                            <The entered 4th parameter '%s' is NOT 'reverse'.>
                            <The entered 4th parameter '%s' was disregarded.>
                            <The 4th parameter should be 'reverse'.>
                            |
                            """, inputParts[3], inputParts[3]);
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

    private InteractiveDictionary() {
        dictionary = new HashMap<>();
        loadDictionaryData();
    }

    // Load dictionary data from the enum
    private void loadDictionaryData() {
        System.out.println("! Loading data...");
        int wordsCount = 0;
        int definitionCount = 0;
        for (EnumDictionaryData data : EnumDictionaryData.values()) {
            String keyword = data.getKeyword().toLowerCase();
            definitionCount++;
            if (!dictionary.containsKey(keyword)) {
                dictionary.put(keyword, new ArrayList<>());
                wordsCount++;
            }
            dictionary.get(keyword).add(data);
        }
        System.out.println("! Loading completed...\n" +
                "===== DICTIONARY 340 JAVA =====\n" +
                "----- Keywords: " + wordsCount + "\n" +
                "----- Definitions: " + definitionCount + "\n");
    }

    // Search the dictionary for matching entries based on the search key and part of speech
    private List<String> search(String searchKey, String partOfSpeech, boolean isDistinct, boolean isReverse) {
        List<String> matchingEntries = new ArrayList<>();
        if (dictionary.containsKey(searchKey)) {
            List<EnumDictionaryData> entries = dictionary.get(searchKey);
            if (partOfSpeech == null) {
                for (EnumDictionaryData entry : entries) {
                    matchingEntries.add(entry.toString());
                }
            } else {
                for (EnumDictionaryData entry : entries) {
                    if (entry.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                        matchingEntries.add(entry.toString());
                    }
                }
            }
            if (isDistinct) {
                matchingEntries = new ArrayList<>(new HashSet<>(matchingEntries));
            }
            Collections.sort(matchingEntries);
            if (isReverse) {
                Collections.reverse(matchingEntries);
            }
        }
        return matchingEntries;
    }

    // Display the search results
    private void displayResults(List<String> entries) {
        if (entries.isEmpty()) {
            System.out.println("|\n <NOT FOUND> To be considered for the next release. Thank you.\n|");
            System.out.println(helpMessage);
        } else {
            System.out.println("|");
            for (String entry : entries) {
                System.out.println(entry);
            }
            System.out.println("|");
        }
    }

    // To be developed in the future
//    private void printWrongParameterMessages(int position, String wrongInputWord){
//        String[] parameters = new String[]{"part of speech","distinct","reverse"};
//        Map<Integer, String> positionOrdinalNumbers = new HashMap<>();
//        positionOrdinalNumbers.put(2, "2nd");
//        positionOrdinalNumbers.put(3, "3rd");
//        positionOrdinalNumbers.put(4, "4th");
//        System.out.println("|");
//        System.out.println("<The entered " + position + "parameter '" + wrongInputWord + "' is NOT a part of speech.>");
//        System.out.println("|");
//    }
//
//        public void wrongParameterNotification(String position, String inputWord) {
//            System.out.print("<The entered " + position + "parameter '" + inputWord + "' is NOT a part of speech.>");
//        }
}
