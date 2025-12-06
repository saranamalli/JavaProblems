package learn.streams;

import java.util.Arrays;
import java.util.List;

public class HelloStreams {
    public static void main(String[] args) {
        int[][] aGrid = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(Arrays.toString(aGrid));
        int[] flatArr = flattenA2DArray(aGrid);
        System.out.println("Flattened Array: "+ Arrays.toString(flatArr));
        int[][] clonedArray = aGrid.clone();
        aGrid[0][1] = 7;
        System.out.println("Cloned: "+clonedArray[0][1]);
        int[] clonedFlat = flatArr.clone();
        flatArr[0] = 7;
        System.out.println("Cloned: "+clonedFlat[0]);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int[] array = numbers.stream().mapToInt(i -> i).toArray();
        
        List<String> list = List.of("Malli", "zString", "srtignz", "strizng");
        list.stream().filter(str -> str.contains("Z") || str.contains("z")).toList();

        // int[] canThisBeAssigned = new int[2][1];
    }

    private static int[] flattenA2DArray(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).toArray();
    }
}
