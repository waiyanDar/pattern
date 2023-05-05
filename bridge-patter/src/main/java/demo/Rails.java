package demo;

public class Rails extends WebFrameWorkBridge{
    public Rails(IPersistance iPersistance) {
        super(iPersistance);
    }

    @Override
    public void play() {
        System.out.println("Rails");
    }

    @Override
    public void execute() {
        iPersistance.persist(new Employee());
        iPersistance.delete(3);
        iPersistance.get();
    }
}
