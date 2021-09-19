package behavioral.delegate;

public class Square implements Graphics{
    @Override
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}
