package learn.leetcode.collections.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class ElementRepeatHalfLenTimesLC961 {

    public static int repeatedNTimes(int[] nums) {
        if(nums.length < 3) return nums[0];
        Deque<Integer> lastThree = new LinkedList<>();
        for(int i:nums) {
            for(int j: lastThree) {
                if(i == j) return i;
            }
            lastThree.offerLast(i);
            if(lastThree.size() > 3) lastThree.removeFirst();
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,7,0,0,9,0,0};
        System.out.println("Element repeated twice: "+repeatedNTimes(nums));
    }
}
