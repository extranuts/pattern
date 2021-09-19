package behavioral.delegate;

public class Painter {

    Graphics graphics;

    //mutator method (set Mutator)
    void setGraphics(Graphics g) {
        graphics = g;
    }

    void draw() {
        graphics.draw();
    }
}
