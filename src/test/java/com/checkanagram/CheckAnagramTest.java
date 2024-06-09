package com.checkanagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckAnagramTest {

    @BeforeEach
    public void setup() {
        CheckAnagram.getStoredStrings().clear();
    }

    @Test
    public void testSortString() {
        assertEquals("eilnst", CheckAnagram.sortString("silent"));
        assertEquals("aehllo", CheckAnagram.sortString("olhlea"));
        assertNotEquals("tixe", CheckAnagram.sortString("exit"));
    }

    @Test
    public void testCheckAnagram() {
        assertTrue(CheckAnagram.checkAnagram("listen", "silent"));
        assertFalse(CheckAnagram.checkAnagram("hello", "world"));
    }

    @Test
    public void testFindAndStoreAnagrams_NoStoredStrings() {
        String newString = "listen";
        CheckAnagram.findAndStoreAnagrams(newString);
        assertTrue(CheckAnagram.getStoredStrings().isEmpty());
    }
}
