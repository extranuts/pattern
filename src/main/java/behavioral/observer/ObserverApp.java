package behavioral.observer;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(25, 760);
        station.setMeasurements(20, 745);
        station.setMeasurements(22, 765);
    }
}

interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

class MeteoStation implements Observed {

    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer {
    public void handleEvent(int temp, int presser) {
        System.out.println("Погода изменилась. Температура = " + temp + ", Давление = " + presser + ".");
    }
}

class FileObserver implements Observer {

    @Override
    public void handleEvent(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Погода изменилась. Температура = " + temp + ", Давление = " + presser + ".");
            pw.println();
            pw.close();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}