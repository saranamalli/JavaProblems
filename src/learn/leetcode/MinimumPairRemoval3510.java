package learn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class MinimumPairRemoval3510 {

    public static void main(String[] args) {
        int[] nums = {2,2,-1,3,-2,2,1,1,1,0,-1};
        // int[] nums = {1, 2, 2};
        System.out.println(minimumPairRemoval(nums) );
    }

    public static int minimumPairRemoval(int[] nums) {
        PriorityQueue<Integer> pairSumSorted = new PriorityQueue<>();
        for(int i=0; i<nums.length-1; i++) {
            pairSumSorted.add(nums[i]+nums[i+1]);
        }

        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        LinkedList<Integer> numsLL = new LinkedList<>(Arrays.asList(numsBoxed));

        int resCount = 0;
        while(!isLLNonDecreasing(numsLL)) {
            int leastSum = pairSumSorted.peek();
            ListIterator<Integer> listIterator = numsLL.listIterator();
            System.out.println(numsLL +" "+ pairSumSorted);
            found: {
                if(listIterator.hasNext()) {
                    listIterator.next();    // neglect 1st number
                }
                while(listIterator.hasNext()) {
                    int previousIndex = listIterator.previousIndex();
                    int previous = listIterator.previous();
                    int but1Previous = Integer.MIN_VALUE;
                    if(listIterator.hasPrevious()) {
                        but1Previous = listIterator.previous();
                        listIterator.next();
                    }
                    listIterator.next();
                    int current = listIterator.next();
                    if((previous+current) == leastSum) {
                        System.out.println("About to Set n remove LL: previousIndex: "+ previousIndex+ " leastSum: "+ leastSum);
                        numsLL.set(previousIndex, leastSum);  // As (numsLL.get(i)+numsLL.get(i+1)) == leastSum
                        numsLL.remove(previousIndex+1);
                        int newNum = previous+current;
                        if(Integer.MIN_VALUE != but1Previous) {
                            pairSumSorted.add(but1Previous+leastSum);
                        }
                        if(listIterator.hasNext()) {
                            int next = listIterator.next();
                            System.out.println("next: "+next);
                            pairSumSorted.add(leastSum+next);
                            listIterator.previous();
                        }
                        resCount++;
                        break found;
                    }
                }
                pairSumSorted.poll();
            }

            // found : {
            //     for(int i=0; i<numsLL.size()-1; i++) {

            //         if((numsLL.get(i)+numsLL.get(i+1)) == leastSum) {
            //             numsLL.set(i, leastSum);    // As (numsLL.get(i)+numsLL.get(i+1)) == leastSum
            //             numsLL.remove(i+1);
            //             pairSumSorted.add(numsLL.get(i)+numsLL.get(i+1));
            //             resCount++;
            //         }
            //     }
            // }
            
        }
        return resCount;
    }

    public static boolean isLLNonDecreasing(LinkedList<Integer> numsLL) {
        ListIterator<Integer> listIterator = numsLL.listIterator();
        if(listIterator.hasNext()) {
            listIterator.next();
        } else {
            return true;
        }

        while(listIterator.hasNext()) {
            int previous = listIterator.previous();
            listIterator.next();
            if(listIterator.next() < previous) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNonDecreasing(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    // public int nextNonMinusOneIndex(int startInd, int[] nums) {

    // }
}
