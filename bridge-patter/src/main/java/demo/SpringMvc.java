package demo;

public class SpringMvc extends WebFrameWorkBridge{
    public SpringMvc(IPersistance iPersistance) {
        super(iPersistance);
    }

    @Override
    public void play() {
        System.out.println("Spring Mvc");
    }

    @Override
    public void execute() {
        iPersistance.persist(new Employee());
        iPersistance.delete(1);
        iPersistance.get();
    }
}
