package demo.leetcode;

public class Sqrtx {

    public static void main(String[] args) {
        int a = 2147483641;
        Sqrtx sqrtx = new Sqrtx();
        System.out.println(sqrtx.sqrtx(a));
    }

    public int sqrtx(int x) {
        for (int i = 0; i <x; i++) {
            if ((i * i) == x) {
                return i;
            }

            if ((i * i) < x && ((long)(i + 1) * (i + 1)) > x) {
                return i;
            }
        }
        return 0;
    }

}