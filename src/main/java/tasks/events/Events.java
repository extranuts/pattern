package tasks.events;


import java.util.EventObject;

public class Events extends EventObject {


    private Type type = Type.TYPE_1;


    public Events(Object source, Type type) {
        super(source);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
