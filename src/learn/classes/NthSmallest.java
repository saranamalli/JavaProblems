package learn.classes;

import java.util.List;
import java.util.stream.Collectors;

public class NthSmallest {
    public static int nthSmallest(int n) {
        int sum = Integer.valueOf(n).toString().chars()
            .mapToObj((c) -> (char)c )
            .map(ch -> Integer.parseInt(ch.toString()))
            .reduce(Integer::sum).orElse(0);
            // .forEach(System.out::println);

        List<Integer> numList = Integer.valueOf(n).toString().chars()
            .mapToObj((c) -> (char)c )
            .map(ch -> Integer.parseInt(ch.toString()))
            .collect(Collectors.toList());

        System.out.println("Sum: " + sum + " List: " + numList);
        return 0;
    }

    public static void main(String[] args) { 
        // System.out.println("Result Obtained: " + nthSmallest(68));
    }
}

// 2 -> 1 -> 
// 10 -> 1 9; 2 7; 9 1; 1 9 0; 
// 8 -> 1 * 8; 2 * 4; 
// 16 -> 1 * 16; 2 * 8; 4 * 4;
// 67 -> 6 7 