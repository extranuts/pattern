package behavioral.chain;

public class AtmSimpleChain {

    public static void main(String[] args) {
        NoteModule note5000 = new NoteModule5000();
        NoteModule note1000 = new NoteModule1000();
        NoteModule note500 = new NoteModule500();
        NoteModule note100 = new NoteModule100();

        note5000.setNextMoneyModule(note1000);
        note1000.setNextMoneyModule(note500);
        note500.setNextMoneyModule(note100);

        note5000.takeMoney(new Money(199_600));
    }
}

class Note {
    public static final int RUR100 = 100;
    public static final int RUR500 = 500;
    public static final int RUR1000 = 1000;
    public static final int RUR5000 = 5000;
}

class Money {
    private int amount;

    public Money(int amount) {
        setAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount > 0 && amount <= 200_000 && amount % Note.RUR100 == 0) {
            this.amount = amount;
        } else {
            throw new RuntimeException("Не более 100 000 и кратная 100 руб");
        }
    }
}

abstract class NoteModule {
    protected NoteModule next;

    abstract void takeMoney(Money money);

    void setNextMoneyModule(NoteModule module) {
        next = module;
    }
}

class NoteModule5000 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.RUR5000;
        int remind = money.getAmount() % Note.RUR5000;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.RUR5000);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule1000 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.RUR1000;
        int remind = money.getAmount() % Note.RUR1000;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.RUR1000);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule500 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.RUR500;
        int remind = money.getAmount() % Note.RUR500;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.RUR500);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule100 extends NoteModule {

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmount() / Note.RUR100;
        int remind = money.getAmount() % Note.RUR100;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.RUR100);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}