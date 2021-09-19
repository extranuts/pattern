package abstractFactory;

import java.util.Map;

public class AbstractFactoryApp {

    public static void main(String[] args) {

    }
}


interface Mouse {
    void click();

    void dblcclick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    Touchpad getTouchpad();
}

class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчек мышью");
    }

    @Override
    public void dblcclick() {
        System.out.println("Двойной щелчек мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скролим ввех");
        } else if (direction < 0) {
            System.out.println("Скролим вниз");
        } else
            System.out.println("Стоим на месте");
    }
}

class RuKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Печатаем строку . . . . .. ");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}

class RuTouchpad implements Touchpad{
    @Override
    public void track(int deltaX, int deltaY) {
        int a = (int) Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + a + " пикселей");
    }
}

// English

class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Single click");
    }

    @Override
    public void dblcclick() {
        System.out.println("Double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll up");
        } else if (direction < 0) {
            System.out.println("Scroll down");
        } else
            System.out.println("NO scroll");
    }
}

class EnKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Writing . . . . .. ");
    }

    @Override
    public void println() {
        System.out.println("Writing &  new ln");
    }
}

class EnTouchpad implements Touchpad{
    @Override
    public void track(int deltaX, int deltaY) {
        int a = (int) Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2));
        System.out.println("Move to " + a + " pxl");
    }
}

class EnDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}

class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}