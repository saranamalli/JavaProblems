package learn.leetcode.two_pointers;

public class MaxConsecutiveOnesLC1004 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println("Result: "+longestOnes(nums, 3));
    }

    public static int longestOnes(final int[] nums, int k) {
        int[] activeZeroes = new int[k];
        final int flips = k;
        int lastZero = -1;
        int start=-1, result = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                if (k>0) {
                    k--;
                    activeZeroes[++lastZero] = i;
                } else {
                    lastZero = (lastZero+1)%flips;
                    start = activeZeroes[lastZero];
                    activeZeroes[lastZero] = i;
                }
            }
            result = Math.max(result, i - start);
        }
        return result;
    }

        public int longestOnesSol(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
}
