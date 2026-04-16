package learn.leetcode.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */
public class MaxLenStrWithKUniqueChars {
    public static int longestKSubstr(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        char currChar, startChar;
        int start=0, result=-1;
        String resultStr="";
        for(int i=0; i<s.length(); i++) {
            currChar = s.charAt(i);
            freqMap.merge(currChar, 1, Integer::sum);
            while(freqMap.size() > k) {
                startChar = s.charAt(start);
                freqMap.merge(startChar, -1, Integer::sum);
                if(freqMap.get(startChar) == 0) freqMap.remove(startChar);
                start++;
            }
            if(freqMap.size() == k) {
                if(i-start+1 > result) {
                    result = i-start+1;
                    resultStr = s.substring(start, i+1);
                }
            }
        }
        System.out.println("Longest string: "+resultStr);
        return result;
    }

    public static void main(String[] args) {
        String inpStr;
        inpStr = "aabacbebebe"; // 3
        // inpStr = "aaaa";    // 2
        // inpStr = "aabaaab"; // 2
        System.out.print("Max str length with K unique characters: "+longestKSubstr(inpStr, 3));
    }
}
