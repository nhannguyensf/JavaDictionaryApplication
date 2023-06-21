import java.util.*;

// Interactive dictionary class
public class InteractiveDictionary {
    private final Map<String, List<EnumDictionaryData>> dictionary;

    public InteractiveDictionary() {
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
                           "----- Keywords: " + wordsCount+ "\n" +
                           "----- Definitions: " + definitionCount +"\n");
    }

    // Search the dictionary for matching entries based on the search key and part of speech
    public List<String> search(String searchKey, String partOfSpeech, boolean isDistinct, boolean isReverse) {
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
    public void displayResults(List<String> entries) {
        if (entries.isEmpty()) {
            System.out.println("|\n <NOT FOUND> To be considered for the next release. Thank you.\n|");
            System.out.println("|\n PARAMETER HOW-TO, please enter:\n" +
                    "1. A search key -then 2. An optional part of speech -then\n" +
                    "3. An optional 'distinct' -then 4. An optional 'reverse'\n|");
        } else {
            System.out.println("|");
            for (String entry : entries) {
                System.out.println(entry);
            }
            System.out.println("|");
        }
    }
}
