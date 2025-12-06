package learn.classes;

public class DeepakPrime {
    public static boolean isPrime(int num) {
        double root = Math.sqrt(num);
        if((int) (root*root) != num) {
            return false;
        }

        for(int i=2; i<(int) root; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is it Deepak Prime: "+ isPrime(49));
    }
}
