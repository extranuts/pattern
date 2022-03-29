package structural.bridge;


/**
 * Разделяет один или несколько классов на две отдельные иерархии —
 * абстракцию и реализацию, позволяя изменять их независимо друг от друга.
 *
 * */
public class BridgeApp {
    public static void main(String[] args) {

    }
}

abstract class Car {
    Make make;

    public Car(Make m) {
        make = m;
    }

    abstract void showDetails();
}

class Sedan extends Car {

    public Sedan(Make m) {
        super(m);
    }

    @Override
    void showDetails() {

    }
}

class Hatchback extends Car {

    public Hatchback(Make m) {
        super(m);
    }

    @Override
    void showDetails() {

    }
}

interface Make {
    void setMake();
}

class Kia implements Make {

    @Override
    public void setMake() {
        System.out.println("KIA");
    }
}

class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}