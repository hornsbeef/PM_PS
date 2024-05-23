package at.ac.uibk.pm.g03.csbb5525.test2.e02;

public class StringManipulator {


    /**
     * Capitalizes the first letter of each word in the given string.
     * Words are delimited by space characters.
     *
     * @param input The string to be capitalized.
     * @return The capitalized string.
     * @throws IllegalArgumentException If the input is null or empty.
     */
    public static String capitalizeWords(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }

        char[] chars = input.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        for (int i = 1; i < chars.length; i++) {    //Cave: starts with 1 !!
            if (chars[i - 1] == ' ') {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }

}
