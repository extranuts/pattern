package creational.prototype;


/**
 * Prototype (Прототип) - помогает создать дублированный объект с
 * лучшей производительностью,
 * вместо нового создается возвращаемый клон существующего объекта.
 * */
public class PrototypeRunner {
    public static void main(String[] args) {

        Human original = new Human(18, "Olya");
        System.out.println(original);

        var copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);

        Human h1 = factory.makeCopy();
        System.out.println(h1);
    }
}

interface Copyable {
    Object copy();
}

class Human implements Copyable {

    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Human(age, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory {
    Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    Human makeCopy() {
        return (Human) human.copy();
    }
}