import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OccurrencesQuantity {
    private static int getOccurrencesQuantity(String inputString, String searchSubstring) {
        int occurrencesQuantity = 0;
        int startIndex = 0;
        String stringLowerCase = inputString.toLowerCase();
        String searchSubstringLowerCase = searchSubstring.toLowerCase();

        while (true) {
            int occurrenceIndex = stringLowerCase.indexOf(searchSubstringLowerCase, startIndex);

            if (occurrenceIndex == -1) {
                return occurrencesQuantity;
            }

            startIndex = occurrenceIndex + searchSubstring.length();
            occurrencesQuantity++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("inputFilms.txt"))) {
            String searchSubstring = "The";
            int occurrencesQuantity = 0;

            while (scanner.hasNextLine()) {
                String inputString = scanner.nextLine();
                occurrencesQuantity += getOccurrencesQuantity(inputString, searchSubstring);
            }

            System.out.println("Quantity of occurrences: " + occurrencesQuantity);
        }
    }
}
