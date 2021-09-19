package behavioral.delegate;

public class DelegateStarter {
    public static void main(String[] args) throws InterruptedException {
        var painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        Thread.sleep(1000);

        painter.setGraphics(new Triangle());
        painter.draw();
    }
}
