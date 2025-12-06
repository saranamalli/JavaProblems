package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSortWithIndices {

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("_____________________________________________________________________________________________________________________");
        System.out.println();
        // List<List<Integer>> inpList = new ArrayList<>(); // 1, 8, 5, 13, 21, 3, 6
        // inpList.add(Arrays.asList(0, 1));
        // inpList.add(Arrays.asList(1, 8));
        // inpList.add(Arrays.asList(2, 5));
        // inpList.add(Arrays.asList(3, 13));
        // inpList.add(Arrays.asList(4, 21));
        // inpList.add(Arrays.asList(5, 3));
        // inpList.add(Arrays.asList(6, 6));

        List<List<Integer>> inpList = new ArrayList<>();
        inpList.add(Arrays.asList(0, 19));
        inpList.add(Arrays.asList(1, 22));
        inpList.add(Arrays.asList(2, 20));
        inpList.add(Arrays.asList(3, 21));

        System.out.println("Sorted List 1: ");
        List<List<Integer>> sortedList1 = sortWithIndices(inpList);
        sortedList1.forEach(a -> System.out.print(a.get(0)+"    "));
        System.out.println();
        sortedList1.forEach(a -> System.out.print(a.get(1)+"   "));

        System.out.println();
        System.out.println("Sorted List 2: ");
        List<List<Integer>> sortedList2 = sortWithIndices2(inpList);
        sortedList2.forEach(a -> System.out.print(a.get(0)+"    "));
        System.out.println();
        sortedList2.forEach(a -> System.out.print(a.get(1)+"   "));
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("_____________________________________________________________________________________________________________________");
        System.out.println();
        
    }

    public static List<List<Integer>> sortWithIndices(List<List<Integer>> inpList) {
        return inpList.stream()
            .sorted((a, b) -> (a.get(1) + a.get(0)) - (b.get(1) + b.get(0)))
            .collect(Collectors.toList());
    }

    public static List<List<Integer>> sortWithIndices2(List<List<Integer>> inpList) {
        return inpList.stream()
            .sorted((a, b) -> (a.get(1) - a.get(0)) - (b.get(1) - b.get(0)))
            .collect(Collectors.toList());
    }
}
