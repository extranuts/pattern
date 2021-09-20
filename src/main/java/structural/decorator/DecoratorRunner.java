package structural.decorator;

public class DecoratorRunner {
    public static void main(String[] args) {
//        PrinterInterface printer = new Printer("Hello, World");
        PrinterInterface printer = new QuotesDecorator(new Printer("Hello"));
        printer.print();
        System.out.println("");
        PrinterInterface printerInterface = new QuotesDecorator(new LeftBracketDecorator
                (new RightBracketDecorator
                        (new Printer("*************"))));
        printerInterface.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {

    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface{
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }
}

class QuotesDecorator extends Decorator {

    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends Decorator{

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }


    @Override
    public void print() {
        System.out.print("{[{");
        component.print();
    }
}
class RightBracketDecorator extends Decorator{

    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        component.print();
        System.out.print("}]}");
    }
}

