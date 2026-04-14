package learn.leetcode.dp;

import java.util.Arrays;

public class MaxDotProductFor2SubseqLC1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1][len2];
        for(int i=0; i<len1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            // System.out.println(Arrays.toString(dp[i]));
        }

        return maxDotProductFromIndices(nums1, nums2, len1-1, len2-1, dp);
    }

    public int maxDotProductFromIndices(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) return (int)-1e9;
        if(dp[i][j] > Integer.MIN_VALUE) return dp[i][j];

        int currProd = nums1[i]*nums2[j];
        dp[i][j] = Math.max(Math.max(currProd, currProd+maxDotProductFromIndices(nums1, nums2, i-1, j-1, dp)), 
                    Math.max(maxDotProductFromIndices(nums1, nums2, i, j-1, dp), maxDotProductFromIndices(nums1, nums2, i-1, j, dp)));
        return dp[i][j];
    }
}