package tasks.events;

import java.util.LinkedList;
import java.util.List;

import static tasks.events.Type.TYPE_1;

public class Runner {

    private List<MyEventListener> eventListeners = new LinkedList<>();

    public void addEventListeners(MyEventListener eventListener){
        eventListeners.add(eventListener);
    }
    public void notifyEventListeners(Events event){
        for (MyEventListener eventListener: eventListeners){
            eventListener.processEvent(event);
        }
    }
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.addEventListeners(event -> {
            if(event.getSource() == null || event.getType() == null) {
                return;
            }
            switch (event.getType()) {
                case TYPE_1 -> System.out.println("FIRST LISTENER");
                case TYPE_2 -> System.out.println("SECOND LISTENER");
                default -> {throw new RuntimeException("NO LISTENERS");}
            }

        });
        runner.addEventListeners(event -> System.out.println("OMG Hello"));
        runner.addEventListeners(event -> System.out.println(event.getType() + " " + event.getSource()));

        runner.notifyEventListeners(new Events(runner, Type.TYPE_2));
    }
}
