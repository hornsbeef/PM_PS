package at.ac.uibk.pm.g03.csbb5525.s06.e02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(Lifecycle.PER_CLASS)
public class PalindromeCheckerTest {

    private PalindromeChecker palindromeChecker;

    @BeforeAll
    public void setUp() {
        this.palindromeChecker = new PalindromeChecker();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Anna", "Otto", "a", "rotator", "kayak", "b2b"})
    public void palindromes(String sequence) {
        assertTrue(palindromeChecker.isPalindrome(sequence));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Amore, Roma!", "Was it a car or a cat I saw?", "Madam, I'm Adam."})
    public void sentencePalindromes(String sequence) {
        assertTrue(palindromeChecker.isPalindrome(sequence));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "123", "16721761", "1a2", "No palindrome!"})
    public void noPalindromes(String sequence) {
        assertFalse(palindromeChecker.isPalindrome(sequence));
    }
}
