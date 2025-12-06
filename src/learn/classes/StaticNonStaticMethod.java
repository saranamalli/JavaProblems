package learn.classes;

public class StaticNonStaticMethod {
    public static void main(String[] args) {
        // Static method call
        staticMethod();

        // Non-static method call
        StaticNonStaticMethod instance = new StaticNonStaticMethod();
        instance.nonStaticMethod();
    }

    public static void staticMethod() {
        System.out.println("This is a static method.");
    }

    public void nonStaticMethod() {
        System.out.println("This is a non-static method.");
    }
}

class InnerStaticNonStaticMethod extends StaticNonStaticMethod {
    public static void main(String[] args) {
        // Static method call
        InnerStaticNonStaticMethod.staticMethod();

        // Non-static method call
        StaticNonStaticMethod instance = new StaticNonStaticMethod();
        instance.nonStaticMethod();
    }

    // public static void staticMethod() {
    //     System.out.println("This is a static method in the inner class.");
    // }

    public void nonStaticMethod() {
        System.out.println("This is a non-static method in the inner class.");
    }

    
}
