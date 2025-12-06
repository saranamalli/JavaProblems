package learn.streams;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
    public Number fizzBuzzStream() {
        IntStream.rangeClosed(1, 100)
            .mapToObj(i -> (i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz" : "") + (i % 3 != 0 && i % 5 != 0 ? i : ""))
            .forEach(System.out::println);
        return null;
    }
}

class buzzfizz extends FizzBuzz {
    public static void main(String[] args) {
        new buzzfizz().fizzBuzzStream();
    }

    @Override
    public Integer fizzBuzzStream() {
        IntStream.rangeClosed(1, 100)
            .mapToObj(i -> (i % 5 == 0 ? "Buzz" : "") + (i % 3 == 0 ? "Fizz" : "") + (i % 3 != 0 && i % 5 != 0 ? i : ""))
            .forEach(System.out::println);
            return null;
    }
}
