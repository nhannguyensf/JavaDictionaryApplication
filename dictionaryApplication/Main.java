import java.util.List;
import java.util.Scanner;

// Main class to run the interactive dictionary
public class Main {
    public static void main(String[] args) {
        InteractiveDictionary dictionary = new InteractiveDictionary();
        Scanner scanner = new Scanner(System.in);

        int searchCount = 1;
        while (true) {
            System.out.print("Search [" + searchCount + "]: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("!q")) {
                System.out.println("----- THANK YOU -----");
                break;
            }
            if (userInput.equals("!help")) {
                System.out.println("PARAMETER HOW-TO, please enter:\n" +
                        "1. A search key -then 2. An optional part of speech -then\n" +
                        "3. An optional 'distinct' -then 4. An optional 'reverse'");
                searchCount++;
                continue;
            }

            String[] inputParts = userInput.split("\\s+");
            String searchKey = inputParts[0];
            String partOfSpeech = inputParts.length > 1 ? inputParts[1] : null;

            List<DictionaryData> matchingEntries = dictionary.search(searchKey, partOfSpeech);
            dictionary.displayResults(matchingEntries);
            searchCount++;
        }

        scanner.close();
    }
}
