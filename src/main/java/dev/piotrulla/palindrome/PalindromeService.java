package dev.piotrulla.palindrome;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class PalindromeService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
    private static final Pattern ONLY_CHARS = Pattern.compile("[^a-zA-Z0-9]");
    private static final String FILE_NAME = "palindrome_{TIME-STAMP}.txt";

    public boolean generateFile(String[] words) {
        try (FileWriter fileWriter = new FileWriter(this.generateFileName())) {
            fileWriter.write(this.check(words));
            return true;
        }
        catch (IOException ignored) {
            return false;
        }
    }

    boolean isPalindrome(String word) {
        String cleanText = this.cleanText(word);

        return cleanText.contentEquals(new StringBuilder(cleanText).reverse());
    }

    private String check(String[] words) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            word = word.trim();
            word = this.cleanText(word);

            if (this.isPalindrome(word)) {
                result.append(word).append(" - jest palindromem\n");
            }
            else {
                result.append(word).append(" - nie jest palindromem\n");
            }
        }

        return result.toString();

    }

    private String cleanText(String text) {
        return text.replaceAll(ONLY_CHARS.pattern(), "").toLowerCase();
    }

    private String generateFileName() {
        String date = DATE_TIME_FORMATTER.format(LocalDateTime.now());

        return FILE_NAME.replace("{TIME-STAMP}", date);
    }

}
