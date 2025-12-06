package learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetsXorTotal1863 {
    public static int subsetXORSum(int[] nums) {
        ArrayList<ArrayList<Integer>> subsets = generateAllSubsets(nums);
        int sum = 0;
        for(ArrayList<Integer> subset: subsets) {
            sum += subsetXor(subset);
        }
        return sum;
    }

    private static int subsetXor(List<Integer> lst) {
        int xor = 0;
        for(int i: lst) {
            xor ^= i;
        }
        return xor;
    }

    private static ArrayList<ArrayList<Integer>> generateAllSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>((int) Math.pow(2, nums.length));
        res.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            int curResSize = res.size();
            for(int j=0; j<curResSize; j++){
                ArrayList<Integer> tempJ = (ArrayList<Integer>) res.get(j).clone();
                tempJ.add(nums[i]);
                res.add(tempJ);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inp = {1,3};
        System.out.println(subsetXORSum(inp));
    }
}

