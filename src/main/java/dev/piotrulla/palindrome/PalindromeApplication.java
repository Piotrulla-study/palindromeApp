package dev.piotrulla.palindrome;

import java.util.Scanner;

public class PalindromeApplication {

    public static void main(String[] args) {
        PalindromeService palindromeService = new PalindromeService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilosc slow do sprawdzenia:");
        int wordsCount;

        try {
            wordsCount = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            System.out.println("Podana wartosc nie jest liczba.");
            return;
        }

        if (wordsCount <= 0) {
            System.out.println("Liczba slow musi byc wieksza od 0.");
            return;
        }

        String exampleWords = generateExampleWords(wordsCount);
        System.out.println("Podaj slowa do sprawdzenia po przecinku (" + exampleWords + "):");

        String[] words = scanner.nextLine().split(",");

        if (words.length != wordsCount) {
            System.out.println("Liczba podanych slow nie zgadza sie z oczekiwana liczba.");
            return;
        }

        if (palindromeService.generateFile(words)) {
            System.out.println("Plik zostal wygenerowany.");
            return;
        }

        System.out.println("Wystapil blad podczas generowania pliku.");
    }

    private static String generateExampleWords(int count) {
        StringBuilder example = new StringBuilder();
        for (int i = 0; i < count; i++) {
            example.append("slowo");
            if (i < count - 1) {
                example.append(", ");
            }
        }
        return example.toString();
    }
}
