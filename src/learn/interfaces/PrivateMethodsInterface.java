package learn.interfaces;

public interface PrivateMethodsInterface {

    // Private method in an interface (Java 9 and later)
    private void privateMethod() {
        System.out.println("This is a private method in an interface.");
    }

    // Default method that calls the private method
    default void callPrivateMethod() {
        privateMethod();
    }

    // Static method that can also call the private method
    private static void staticMethod() {
        // Cannot call privateMethod() here, as it's not in a default or static context
        System.out.println("This is a static method in an interface.");
    }
}