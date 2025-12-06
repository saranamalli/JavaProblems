package learn.flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloFlux {
    public static void main(String[] args) {
        String sentence = "This is a string literal";
        List<String> wordList = Arrays.asList(sentence.split(" "));

        List<List<String>> nestedList = List.of(List.of("a", "b"), List.of("c", "d"));
        List<String> flatList = nestedList.stream()
                                  .flatMap(List::stream) 
                                  .collect(Collectors.toList());

    }
}
