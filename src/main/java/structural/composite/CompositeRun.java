package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeRun {
    public static void main(String[] args) {

        var square = new Square();
        var square1 = new Square();
        var triangle = new Triangle();
        var square2 = new Square();
        var circle = new Circle();
        var circle1 = new Circle();

        var composite = new Composite();
        var composite1 = new Composite();
        var composite2 = new Composite();

        composite.addComponent(square);
        composite.addComponent(square1);
        composite1.addComponent(triangle);
        composite2.addComponent(square2);
        composite2.addComponent(circle);
        composite1.addComponent(circle1);
        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();

    }
}

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("I am SQUARE");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am TRIANGLE");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am CIRCLE");
    }
}

class Composite implements Shape {

    private final List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}

