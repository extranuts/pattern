package builder;

public class BuilderApp {

    public static void main(String[] args) {

    }

}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make){this.make = make;}
    public void setTransmission(Transmission transmission) {this.transmission = transmission;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}
}
