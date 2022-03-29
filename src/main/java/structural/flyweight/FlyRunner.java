package structural.flyweight;

import java.util.*;


/**
 * Позволяет вместить бóльшее количество объектов в отведённую оперативную память.
 * Легковес экономит память, разделяя общее состояние объектов между собой,
 * вместо хранения одинаковых данных в каждом объекте.
 *
 * */

public class FlyRunner {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));

        Random random = new Random();
        for (Shape s: shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            s.draw(x, y);
        }
    }
}

interface Shape {
    void draw(int x, int y);
}

class Point implements Shape {
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw point ");
    }
}

class Circle implements Shape {
    @Override
    public void draw(int x, int y) {
        int r = 5;
        System.out.println("(" + x + "," + y + "): draw circle with r =  " + r);
    }
}

class Square implements Shape {
    @Override
    public void draw(int x, int y) {
        int a = 10;
        System.out.println("(" + x + "," + y + "): draw square with side = " + a);
    }
}

class ShapeFactory {

    public static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName) {

        Shape shape = shapes.get(shapeName);

        if (shape == null) {
            switch (shapeName) {
                case "circle" -> shape = new Circle();
                case "square" -> shape = new Square();
                case "point" -> shape = new Point();
            }
            shapes.put(shapeName, shape);
        }

        return shape;
    }
}