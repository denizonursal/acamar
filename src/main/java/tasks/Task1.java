package tasks;

/**
 * Given a string s consisting of some words separated by some number of spaces,
 * return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example input: "Hello World"
 *
 * Expected output: 5
 */
public class Task1 {

    private Task1() {}

    /**
     *
     * @param text - Given string.
     * @return - The length of the last word.
     */
    public static int solution(String text) {
        final var words = text.split("\\s+");
        return words[words.length - 1].length();
    }
}
