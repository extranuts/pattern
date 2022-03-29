package behavioral.state;


/**
 *State (Состояние) -
 *  объект может изменять свое поведение в зависимости от его состояния.
 * */

public class StateRunner {
    public static void main(String[] args) {

        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();

        }
    }
}

//state
interface Station {
    void play();
}

class RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("Play radio DFM . ... .. .");
    }
}

class RadioEnergy implements Station {
    @Override
    public void play() {
        System.out.println("Play radio Energy . .. . .. .");
    }
}

//Context
class Radio {

    Station station;
    void setStation(Station st) {
        station = st;
    }

    void nextStation() {
        if(station instanceof RadioDFM) {
            setStation(new RadioDFM());
        }
        else if (station instanceof RadioEnergy) {
            setStation(new RadioEnergy());
        }
    }

    void play() {
        station.play();
    }
}