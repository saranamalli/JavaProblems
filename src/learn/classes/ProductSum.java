package learn.classes;

import java.util.Arrays;

public class ProductSum {

    public static void main(String[] args) {
        System.out.println("Numbers whose sum or product is c: "+ Arrays.toString(product(10)));
        
    }

    public static double[] product(int c) {
        double res[]  = new double[2];
        res[0] = (c + Math.sqrt(c*c - 4*c))/2;
        res[1] = (c - Math.sqrt(c*c - 4*c))/2;
        return res;
    }
}

