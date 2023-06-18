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
    public List<EnumDictionaryData> search(String searchKey, String partOfSpeech) {
        List<EnumDictionaryData> matchingEntries = new ArrayList<>();
        String searchKeyLower = searchKey.toLowerCase();

        if (dictionary.containsKey(searchKeyLower)) {
            List<EnumDictionaryData> entries = dictionary.get(searchKeyLower);
            if (partOfSpeech == null) {
                matchingEntries.addAll(entries);
            } else {
                for (EnumDictionaryData entry : entries) {
                    if (entry.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                        matchingEntries.add(entry);
                    }
                }
            }
        }
        return matchingEntries;
    }

    // Display the search results
    public void displayResults(List<EnumDictionaryData> entries) {
        if (entries.isEmpty()) {
            System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
        } else {
            System.out.println("|");
            for (EnumDictionaryData entry : entries) {
                System.out.println(entry.toString());
            }
            System.out.println("|");
        }
    }
}
