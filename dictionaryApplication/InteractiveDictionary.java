import java.util.*;

// Interactive dictionary class
public class InteractiveDictionary {
    private final Map<String, List<DictionaryData>> dictionary;

    public InteractiveDictionary() {
        dictionary = new HashMap<>();
        loadDictionaryData();
    }

    // Load dictionary data from the enum
    private void loadDictionaryData() {
        for (DictionaryData data : DictionaryData.values()) {
            String keyword = data.getKeyword().toLowerCase();
            if (!dictionary.containsKey(keyword)) {
                dictionary.put(keyword, new ArrayList<>());
            }
            dictionary.get(keyword).add(data);
        }
    }

    // Search the dictionary for matching entries based on the search key and part of speech
    public List<DictionaryData> search(String searchKey, String partOfSpeech) {
        List<DictionaryData> matchingEntries = new ArrayList<>();
        String searchKeyLower = searchKey.toLowerCase();

        if (dictionary.containsKey(searchKeyLower)) {
            List<DictionaryData> entries = dictionary.get(searchKeyLower);
            if (partOfSpeech == null) {
                matchingEntries.addAll(entries);
            } else {
                for (DictionaryData entry : entries) {
                    if (entry.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                        matchingEntries.add(entry);
                    }
                }
            }
        } else {
            System.out.println("No matching entries found.");
        }

        return matchingEntries;
    }

    // Display the search results
    public void displayResults(List<DictionaryData> entries) {
        if (entries.isEmpty()) {
            System.out.println("No matching entries found.");
        } else {
            for (DictionaryData entry : entries) {
                System.out.println(entry.toString());
            }
        }
    }
}
