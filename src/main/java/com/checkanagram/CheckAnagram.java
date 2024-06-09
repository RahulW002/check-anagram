package com.checkanagram;

import java.util.*;

/**
 * This class provides functionality to check anagrams for multiple String values.
 * This is interactive program user can input String and can check the anagram with the previously entered Strings.
 */
public class CheckAnagram {


    private static final List<String> storedStrings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String messageToUser = storedStrings.isEmpty() ? "Enter an input String value (or type 'q' to quit): " : "Enter another String (or type 'q' to quit): ";

            System.out.println("\n" + messageToUser);
            String input = scanner.nextLine().toLowerCase();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting...");
                break;
            }
            findAndStoreAnagrams(input);
            if (!storedStrings.contains(input)) {
                storedStrings.add(input);
            }
        }
        scanner.close();
    }

    /**
     * Finds if the new string is an anagram of any previously stored strings and stores them.
     *
     * @param newString The new string to check for anagrams
     */

    protected static void findAndStoreAnagrams(String newString) {
        if (storedStrings.isEmpty()) {
            System.out.println("\nThanks for the first input, " +
                    "need to enter second value to check anagram String " +
                    "with the first one");
        } else {
            System.out.println("Anagram String Results are as follows :- ");
            storedStrings.stream()
                    .filter(storedString -> !newString.equals(storedString) && checkAnagram(storedString, newString))
                    .forEach(storedString -> System.out.println("- " + storedString));
        }
    }

    /**
     * Determines if two strings are anagrams of each other.
     *
     * @param firstStringValue  The first string
     * @param secondStringValue The second string
     * @return True if the strings are anagrams, false otherwise
     */
    protected static boolean checkAnagram(String firstStringValue, String secondStringValue) {
        return sortString(firstStringValue).equals(sortString(secondStringValue));
    }

    /**
     * Sorts the characters of a string in alphabetical order.
     *
     * @param inputValue The string to sort
     * @return The sorted string
     */
    protected static String sortString(String inputValue) {
        char[] arr = inputValue.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static List<String> getStoredStrings() {
        return storedStrings;
    }
}