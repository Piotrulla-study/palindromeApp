package dev.piotrulla.palindrome;

import java.util.Scanner;

public class PalindromeApplication {

    public static void main(String[] args) {
        PalindromeService palindromeService = new PalindromeService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilość słów do sprawdzenia:");
        int wordsCount;

        try {
            wordsCount = Integer.parseInt(scanner.nextLine().trim());

            if (wordsCount <= 0) {
                throw new NumberFormatException("Liczba słów musi być większa od 0.");
            }

        }
        catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println("Podaj słowa do sprawdzenia po przecinku: ");

        String[] words = scanner.nextLine().split(",");

        if (words.length != wordsCount) {
            System.out.println("Liczba podanych słów nie zgadza się z oczekiwaną liczbą.");
            return;
        }

        if (palindromeService.generateFile(words)) {
            System.out.println("Plik został wygenerowany.");

            return;
        }

        System.out.println("Wystąpił błąd podczas generowania pliku.");
    }
}
