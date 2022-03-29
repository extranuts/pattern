package behavioral.templateMethod;

/**
 *
 *Определяет скелет алгоритма, перекладывая ответственность за некоторые его
 *  шаги на подклассы. Паттерн позволяет подклассам переопределять шаги алгоритма,
 *  не меняя его общей структуры.
 * */


public class TMRunner {
    public static void main(String[] args) {
        C a = new A();
        a.templateMethod();

        System.out.println();

        var b = new B();
        b.templateMethod();


    }
}

abstract class C {
    void templateMethod() {
        System.out.println("1");
        different();
        System.out.println("3");
        different2();

    }

    protected abstract void different2();

    protected abstract void different();
}

class A extends C {

    @Override
    protected void different2() {
        System.out.println("--------------------");
    }

    @Override
    protected void different() {
        System.out.println("2");
    }
}

class B extends C {

    @Override
    protected void different2() {

    }

    @Override
    protected void different() {
        System.out.println("4");
    }
}
