package learn.streams;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

// Write a Program using stream API I/p = Str string = Rahul Dravid O/p=Str uniqueString = Rahul Dvi // remove duplicate elements from the words

public class UniqueCharsWord {
    public static void main1(String[] args) {
        String input = "Rahul Dravid";
        input = "Aa";
        input.chars()
            // .map(a -> a > 96 ? )
            // .mapToObj(opt -> (char) opt)
            .forEach(System.out::println);
    }

    public static void main2(String[] args) {
        String str = "Rahul Dravid";

        String uniqueString = str.chars() // Convert to IntStream of characters
                .mapToObj(c -> (char) c) // Convert int to Character
                // .filter(c -> c != ' ')   // Optional: keep or remove space
                .collect(Collectors.toCollection(LinkedHashSet::new)) // Remove duplicates
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Unique String: " + uniqueString);
    }

    public static void main(String[] args) {
        String str = "Rahul Dravid";

        String uniqueString = str.chars() // Convert to IntStream of characters
                .mapToObj(c -> (char) c) // Convert int to Character
                .filter(c -> c != ' ')   // Optional: keep or remove space
                .collect(Collectors.toCollection(LinkedHashSet::new)) // Remove duplicates
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Unique String: " + uniqueString);
    }
}

