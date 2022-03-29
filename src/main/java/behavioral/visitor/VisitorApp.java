package behavioral.visitor;

/**
 * Позволяет создавать новые операции,
 * не меняя классы объектов, над которыми эти операции могут выполняться.
 * **/


public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor hooliganVisitor = new HooliganVisitor();

        body.accept(hooliganVisitor);
        engine.accept(hooliganVisitor);

    }
}

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);
}

interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Start engine...without key ");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Broken window with stone");
    }
}

class NormalVisitor implements Visitor {
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Start engine with key");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Open door with key");
    }
}