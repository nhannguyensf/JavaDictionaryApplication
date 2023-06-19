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
        for (EnumDictionaryData data : EnumDictionaryData.values()) {
            String keyword = data.getKeyword().toLowerCase();
            if (!dictionary.containsKey(keyword)) {
                dictionary.put(keyword, new ArrayList<>());
            }
            dictionary.get(keyword).add(data);
        }
    }

    // Search the dictionary for matching entries based on the search key and part of speech
    public List<String> search(String searchKey, String partOfSpeech, boolean isDistinct, boolean isReverse) {
        List<String> matchingEntries = new ArrayList<>();
        String searchKeyLower = searchKey.toLowerCase();

        if (dictionary.containsKey(searchKeyLower)) {
            List<EnumDictionaryData> entries = dictionary.get(searchKeyLower);
            if (partOfSpeech == null) {
                for (EnumDictionaryData entry : entries) {
                    matchingEntries.add(entries.toString());
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
            System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
        } else {
            System.out.println("|");
            for (String entry : entries) {
                System.out.println(entry);
            }
            System.out.println("|");
        }
    }
}
