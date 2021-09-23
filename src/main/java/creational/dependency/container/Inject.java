package creational.dependency.container;


import java.util.HashMap;
import java.util.Map;


public class Inject {

    private Map<Class<?>, Class<?>> diMap;
    private Map<Class<?>, Object> applicationScope;

    private static Inject injector;

    private Inject() {
        super();
        diMap = new HashMap<>();
        applicationScope = new HashMap<>();
    }

    public static void startApplication(Class<?> mainClass) {

    }
}