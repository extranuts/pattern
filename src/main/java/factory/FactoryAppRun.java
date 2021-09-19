package factory;

import java.util.Date;

public class FactoryAppRun {
    public static void main(String[] args) {

//        Watch watch = new DigitalWatch();
//        watch.showTime();
//
//        Watch watch1 = new RomeWatch();
//        watch1.showTime();

        WatchMaker maker = new DigitalWatchMaker();
        var watch = maker.createWatch();
        watch.showTime();

    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomainWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}


interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VII-XX");
    }
}
