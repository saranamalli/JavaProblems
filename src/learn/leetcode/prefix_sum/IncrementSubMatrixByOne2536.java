package learn.leetcode.prefix_sum;

import java.util.Arrays;

public class IncrementSubMatrixByOne2536 {
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];
        // for(int i: IntStream.range(0, n).toArray()) {
        //     System.out.println(Arrays.toString(result[i]));
        // }
        for(int[] qry: queries) {
            // System.out.println(Arrays.toString(qry));
            int startRow = qry[0], startCol = qry[1], endRow = qry[2], endCol = qry[3];
            for(int i=startRow; i<=endRow; i++) {
                result[i][startCol] += 1;
                if(endCol+1 < n) 
                    result[i][endCol+1] -= 1;
            }
        }

        for(int i=0; i<n; i++) {
            int prev = 0;
            for(int j=0; j<n; j++) {
                result[i][j] += prev;
                prev = result[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] queries = {{1,1,2,2}, {0,0,1,1}}, result;
        int n = 3;
        result = rangeAddQueries(n, queries);
        for(int i=0; i<n; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
