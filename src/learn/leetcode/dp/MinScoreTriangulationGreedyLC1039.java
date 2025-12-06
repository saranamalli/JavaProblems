package learn.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinScoreTriangulationGreedyLC1039 {
    public static int minScoreTriangulation(int[] values) {
        int size = values.length;
        if (size < 3) {
            return 0;
        } else if(size == 3) {
            return values[0] * values[1] * values[2];
        } 

        int minInd1 = smallestElementIndex(values);
        int[] newValues = values.clone();
        newValues[minInd1] = Integer.MAX_VALUE; 
        newValues[(minInd1-1+values.length)%values.length] = Integer.MAX_VALUE; 
        newValues[(minInd1+1)%values.length] = Integer.MAX_VALUE; 
        System.out.println("NewValues: "+Arrays.toString(newValues));
        System.out.println("Values: "+Arrays.toString(values));
        int minInd2 = smallestElementIndex(newValues);
        System.out.println("minInd1: "+minInd1+" minInd2: "+minInd2);
        if(values[minInd1]*values[minInd2] > values[(minInd1-1+values.length)%values.length]*values[(minInd1+1)%values.length]) {
            minInd2 = (minInd1-1+values.length)%values.length;
            minInd1 = (minInd1+1)%values.length;
        }
        System.out.println("minInd1: "+minInd1+" minInd2: "+minInd2);
        List<Integer> valuesLs1 = new ArrayList<>(), valuesLs2 = new ArrayList<>();
        int minind = Math.min(minInd1, minInd2);
        int maxind = Math.max(minInd1, minInd2);
        minInd1 = minind;
        minInd2 = maxind;
        for(int i=0; i<values.length; i++) {
            if(i>=minInd1 && i<=minInd2)    
                valuesLs2.add(values[i]);
            if(i<=minInd1 || i>=minInd2)
                valuesLs1.add(values[i]);
        }
        System.out.println("LS1: "+valuesLs1+"LS2: "+valuesLs2);

        return minScoreTriangulation(valuesLs1.stream().mapToInt(i -> i).toArray()) 
            + minScoreTriangulation(valuesLs2.stream().mapToInt(Integer::intValue).toArray());
    }

    public static int smallestElementIndex(int[] arr) {
        int ind = 0, minElem = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < minElem) {
                ind = i;
                minElem = arr[i];
            }
        }
        return ind;
    }

    public static void main(String[] args) {
        // int[][] polygons = {{1,2,3}, {3, 7, 4, 5}, {1,3,1,4,1,5}, {4,3,1,3}};
        int[][] polygons = {{4,3,1,3}};
        for(int[] polygon: polygons) {
            System.out.println("Polygon: "+Arrays.toString(polygon));
            System.out.println("Result: "+minScoreTriangulation(polygon));
        }
    }
}
