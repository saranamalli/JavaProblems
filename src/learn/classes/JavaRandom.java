package learn.classes;

import java.util.Random;
import java.util.stream.IntStream;

public class JavaRandom {
    public static void main(String[] args) {
        Random randInt = new Random(25);
        for(int i: IntStream.range(1, 10).toArray()) {
            System.out.println("Next Random Integer: "+randInt.nextInt(i));
        }
    }
}
