package facade;

public class FacadeRunner {

    public static void main(String[] args) {

//        var power = new Power();
//        power.on();
//
//        var dvd = new DVDRom();
//        dvd.load();
//
//        var hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        var computerFacade = new ComputerFacade();
        computerFacade.copy();

    }
}

class ComputerFacade {

    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Включение компьютера");
    }

    void off() {
        System.out.println("Выключение компьютера");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Происходит копирование данных с диска");
        } else
            System.out.println("Вставьте диск с данными");
    }
}