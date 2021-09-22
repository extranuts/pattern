package tasks.events;

import java.util.EventListener;

public interface MyEventListener extends EventListener {
    void processEvent(Events event);
}
