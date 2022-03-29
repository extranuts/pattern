package behavioral.chain;

/**
 *Chain of Responsibility (Цепочка обязанностей) -
 * позволяет избежать жесткой зависимости отправителя запроса от его получателя,
 *  при этом запрос может быть обработан несколькими объектами.
 *
 * */

public class ChainOfResponsibility {

    public static void main(String[] args) {
        Logger logger1 = new SMSLogger(Level.ERROR);
        Logger logger2 = new FileLogger(Level.DEBUG);
        Logger logger3 = new EmailLogger(Level.INFO);

        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.writeMessage("ALL OK", Level.INFO);
        logger1.writeMessage("OMG", Level.DEBUG);
        logger1.writeMessage("ERROR (", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger {
    int priority;
    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);
}

class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("CMC: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Writes to file:  " + message);
    }
}

class EmailLogger extends Logger {


    public EmailLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Send to Email: " + message);
    }
}