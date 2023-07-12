package demo;

public class Main extends Parent{
    int i = 10;
    public static void main(String[] args) {
        Main main = new Main();
        main.test();
    }
    public void test(){
        System.out.println(i);
    }
}

class Parent{
    int i = 100;
    Parent(){
        test();
    }
    public void test(){
        System.out.println(i);
    }
}