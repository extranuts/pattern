package factory;

import java.util.Date;

public class FactoryAppRun {
    public static void main(String[] args) {

//        Watch watch = new DigitalWatch();
//        watch.showTime();
//
//        Watch watch1 = new RomeWatch();
//        watch1.showTime();

//        WatchMaker maker = new DigitalWatchMaker();
//        var watch = maker.createWatch();
//        watch.showTime();

        WatchMaker maker = getMakerByName("Digital");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomainWatchMaker();
        throw new RuntimeException("You can use only: \"Digital\" & \"Rome\" ");
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
