package learn.lambda;

import java.util.function.Function;

public class LearnLambda {

    int field;
    public static void main(String[] args) {
        Integer b = 10000;
        LearnLambda learn = new LearnLambda();
        learn.field = 3;
        learn.field = 4;
        Function<Integer, Integer> doubleFunc = (a) -> a*b;
        System.out.println("Double Func: "+doubleFunc.apply(3));
    }
}
