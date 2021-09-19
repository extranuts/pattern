package abstractFactory;

public class AbstractFactoryApp {

    public static void main(String[] args) {

    }
}


interface Mouse{
    void click();
    void dblcclick();
    void scroll(int direction);
}
interface Keyboard{
    void print();
    void println();
}
interface Touchpad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

