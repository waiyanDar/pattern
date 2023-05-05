package demo;

public class Main {
    public static void main(String[] args) {
        WebFrameWorkBridge bridge = new SpringMvc(new MyBatis());
        bridge.execute();
        bridge.play();
    }
}