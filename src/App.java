import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.IntFunction;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4,5,6,7};
        
        Integer[] numsInt = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        LinkedList<Integer> llist = new LinkedList<>(Arrays.asList(numsInt));

        ListIterator llIterator = llist.listIterator();
        llIterator.next();  // neglect first number
        while(llIterator.hasNext()) {
            System.out.println(llIterator.previous()+" "+ llIterator.next());
            llist.set(llIterator.previousIndex(), 45);
            llIterator.next();
        }
        System.out.println(llist);
    }
}
