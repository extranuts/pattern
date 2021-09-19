package factory;

import java.util.Date;

public class FactoryAppRun {
    public static void main(String[] args) {
        Watch watch = new DigitalWatch();
        watch.showTime();

        Watch watch1 = new RomeWatch();
        watch1.showTime();

    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}
