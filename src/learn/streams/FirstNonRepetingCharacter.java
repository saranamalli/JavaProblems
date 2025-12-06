package learn.streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepetingCharacter {
    public static void main(String[] args) {
        String inp = "swiss";
        inp.chars()
            // .forEach(c -> System.out.println((char) c));
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() == 1)
            .findFirst()
            .ifPresent(e -> System.out.println("First non-repeating character: " + e.getKey()));
    }
}
