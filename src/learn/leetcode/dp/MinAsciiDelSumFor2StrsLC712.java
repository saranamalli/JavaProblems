package learn.leetcode.dp;

import java.util.Arrays;

public class MinAsciiDelSumFor2StrsLC712 {
    public static int minimumDeleteSum(String s1, String s2) {
        int lenOfS1 = s1.length(), lenOfS2 = s2.length();
        int[][] dp = new int[lenOfS1+1][lenOfS2+1];
        dp[0][0] = 0;
        for(int i=1; i<lenOfS2+1; i++){
            dp[0][i] = dp[0][i-1] + (int) s2.charAt(i-1);
        }
        System.out.println(Arrays.toString(dp[0]));
        for(int i=1; i<lenOfS1+1; i++){
            dp[i][0] = dp[i-1][0] + (int) s1.charAt(i-1);
            System.out.println(Arrays.toString(dp[i]));
        }
        // for(int i=0; i)
        return 0;
    }

    public static void main(String[] args) {
        String str1 = "delete", str2 = "leet";
        System.out.format("For %s, %s: %d", str1, str2, minimumDeleteSum(str1, str2));
    }
}
