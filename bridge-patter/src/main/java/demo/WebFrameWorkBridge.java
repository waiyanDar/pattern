package demo;

public abstract class WebFrameWorkBridge {

    protected IPersistance iPersistance;

    public WebFrameWorkBridge(IPersistance iPersistance) {
        this.iPersistance = iPersistance;
    }

    public abstract void play();
    public abstract void execute();
//    public abstract void test();
}
