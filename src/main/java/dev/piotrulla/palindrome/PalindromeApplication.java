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

            if (wordsCount <= 0) {
                throw new NumberFormatException("Liczba slow musi byc wieksza od 0.");
            }

        }
        catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println("Podaj slowa do sprawdzenia po przecinku: ");

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
}
