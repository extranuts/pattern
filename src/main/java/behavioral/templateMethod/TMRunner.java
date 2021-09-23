package behavioral.templateMethod;

public class TMRunner {
    public static void main(String[] args) {
        A a = new A();
        a.method();

        System.out.println();

        var b = new B();
        b.method();


    }
}
class A{
    void method(){
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }
}
class B{
    void method(){
        System.out.println("1");
        System.out.println("4");
        System.out.println("3");
    }
}
