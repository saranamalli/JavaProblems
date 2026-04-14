package learn.classes;

public class MethodOverride {
    public static void main(String[] args) {
		Child childOne = new Child();   // In Child Method null
		childOne.parentMethod();       // In Child Method y
	}
}

class Parent {
    String str1 = "x";
	public Parent() {
        System.out.println("In Parent Constructor "+ str1 + " "+str3+ " ");
		parentMethod();
	}
	void parentMethod() {
		System.out.println("In Parent method "+ str1 + " ");
	}
    String str3 = "z";
}
class Child extends Parent {
	String str2 = "y";
	void parentMethod() {
		System.out.println("In Child Method "+ str2 + " ");
	}
}