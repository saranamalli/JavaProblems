package learn.leetcode.memoization;

import java.util.Arrays;

public class SumOfSquares {
    private int[] minSquares = new int[10000];

    public SumOfSquares() {
        Arrays.fill(minSquares, -1);      
        minSquares[0] = 0;
        minSquares[1] = 1;
    }

    public int countMinSquares(int A) {
        if (minSquares[A] != -1) {
            return minSquares[A];
        }
        int mini = Integer.MAX_VALUE;
        for(int i= (int)Math.sqrt(A);i>0;i--){
            mini = Math.min(mini, countMinSquares(A-i*i));
        }
        minSquares[A] = mini;
        return minSquares[A];
    }

}
