package dev.piotrulla.palindrome;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeServiceTest {

    private final PalindromeService palindromeService = new PalindromeService();

    @Test
    public void testPalindromeWithSimpleWord() {
        assertTrue(isPalindrome("radar"));
    }

    @Test
    public void testPalindromeWithMixedCase() {
        assertTrue(isPalindrome("RaceCar"));
    }

    @Test
    public void testNonPalindrome() {
        assertFalse(isPalindrome("hello"));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(isPalindrome("a"));
    }

    private boolean isPalindrome(String word) {
        return this.palindromeService.isPalindrome(word);
    }
}
