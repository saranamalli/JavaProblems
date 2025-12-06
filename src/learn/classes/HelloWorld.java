package learn.classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class HelloWorld {
    public static void main(String[] args) { 
        // printConsec(100, 9001, 9);
        // System.out.println("Result Obtained: " + nthSmallest(68));

        learnListIterator();
    }

    public static void printConsec(int n, int start, int inc) {
        List<Integer> nums = new ArrayList<>(n/inc + 1);
        nums.add(start);
        while(n > 0) {
            nums.add(getLast(nums)+inc);
            n--;
        }
        System.out.println("printConsec: "+ nums);
    }

    private static int getLast(List<Integer> nums) {
        return nums.get(nums.size()-1);
    }

    public static void learnListIterator() {
        LinkedList<String> list = new LinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String current = iterator.next();

            if (current.equals("banana")) {
                iterator.set("blueberry");  // ✅ Safe update
            }

            if (current.equals("cherry")) {
                iterator.remove();          // ✅ Safe removal
            }

            if (current.equals("apple")) {
                iterator.add("avocado");    // ✅ Safe addition after "apple"
            }
        }

        System.out.println("Updated list: " + list);
    }
}
