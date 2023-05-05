package demo;

public class Grails extends WebFrameWorkBridge{
    public Grails(IPersistance iPersistance) {
        super(iPersistance);
    }

    @Override
    public void play() {
        System.out.println("Grail");
    }

    @Override
    public void execute() {
        iPersistance.persist(new Employee());
        iPersistance.delete(2);
        iPersistance.get();
    }
}
