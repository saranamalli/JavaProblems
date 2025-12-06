package learn.leetcode.dp;

import java.util.Arrays;

public class MinScoreTriangulationSolLC1039 {

    public static int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        return dp(values, dp, 0, n-1);
    }

    public static int dp(int[] values, int[][] dp, int start, int endInclusive) {
        if(dp[start][endInclusive] != 0)
            return dp[start][endInclusive];

        if(endInclusive-start < 2) {
            return 0;
        }

        if(endInclusive-start == 2) {
            dp[start][endInclusive] = values[start]*values[start+1]*values[endInclusive];
            return dp[start][endInclusive];
        }

        int tempRes = Integer.MAX_VALUE;
        for(int k=start+1; k<endInclusive; k++) {
            tempRes = Math.min(tempRes, 
                dp(values, dp, start, k) + values[start]*values[k]*values[endInclusive] + dp(values, dp, k, endInclusive));
        }
        dp[start][endInclusive] = tempRes;
        return tempRes;
    }

    public static void main(String[] args) {
        int[][] polygons = {{1,2,3}, {3, 7, 4, 5}, {1,3,1,4,1,5}, {4,3,1,3}};
        // int[][] polygons = {{4,3,1,3}};
        for(int[] polygon: polygons) {
            System.out.println("Polygon: "+Arrays.toString(polygon));
            System.out.println("Result: "+minScoreTriangulation(polygon));
        }
    }
}
