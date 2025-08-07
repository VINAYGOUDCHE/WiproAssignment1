package New;
public class A42 {
    
    static void someMethod2() throws Exception {
        throw new Exception("Exception from someMethod2");
    }

    static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Caught in someMethod, rethrowing");
            throw e; // rethrowing the caught exception
        }
    }

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Caught in main:");
            e.printStackTrace(); // prints full stack trace
        }
    }
}
/*
Caught in someMethod, rethrowing
Caught in main:
java.lang.Exception: Exception from someMethod2
	at New.A42.someMethod2(A42.java:5)
	at New.A42.someMethod(A42.java:10)
	at New.A42.main(A42.java:19)

*/