package learn.leetcode.two_pointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ReverseWordsInStr151 {
    private static final char SPACE = ' ';

    public static void main(String[] args) {
        String[] strsToReverse = { "the sky is blue",
                "  hello world  ", "a good   example" };

        String[] reversedStrs = new String[strsToReverse.length];
        for (int i = 0; i < strsToReverse.length; i++) {
            reversedStrs[i] = splitJoin(strsToReverse[i].strip());
        }
        System.out.println(Arrays.toString(reversedStrs));
    }

    /**
     * OptimizedSolution TC : O(N) SC : O(1) in-place
     */
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        // Step 1 : Remove leading or trailing or spaces in-between
        int len = 0, i = 0;
        while (i < chars.length) {

            while (i < chars.length && chars[i] == SPACE)
                i++;

            if (i < chars.length && len > 0)
                chars[len++] = SPACE;

            while (i < chars.length && chars[i] != SPACE)
                chars[len++] = chars[i++];
        }

        // Step 2 : Reverse array
        reverse(chars, 0, len - 1);

        // Step 3 : Reverse each word of array
        int start = 0, end = 0;
        while (end < len) {
            if (chars[end] == SPACE) {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        reverse(chars, start, end - 1);
        return new String(chars, 0, len);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i <= j) {
            char ch = chars[i];
            chars[i++] = chars[j];
            chars[j--] = ch;
        }
    }

    private static String splitJoin(String str) {
        StringBuilder wordBuilder = new StringBuilder();
        String[] words = str.split("\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            wordBuilder.append(words[i]);
            wordBuilder.append(" ");
        }
        return wordBuilder.toString().trim();
    }

    private static String reverseWordsUsingLL(String str) {
        StringBuilder wordBuilder = new StringBuilder();
        List<String> wordsLL = new LinkedList<>();

        for (char ch : str.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                if (!wordBuilder.toString().isBlank()) {
                    wordsLL.add(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                }
            } else {
                wordBuilder.append(ch);
            }
        }
        if (!wordBuilder.toString().isBlank()) {
            wordsLL.add(wordBuilder.toString());
        }
        StringBuilder resBuilder = new StringBuilder();
        if (!wordsLL.isEmpty()) {
            ListIterator<String> itr = wordsLL.listIterator(wordsLL.size());
            while (itr.hasPrevious()) {
                resBuilder.append(itr.previous());
                if (itr.hasPrevious()) {
                    resBuilder.append(" ");
                }
            }
        }

        return resBuilder.toString();
    }
}
