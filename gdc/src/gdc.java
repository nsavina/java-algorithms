import java.util.Scanner;

public class gdc {
    public static void main(String[] args) {
        // put your code here\\
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(new gdc().findGdc(n, m));
//        new gdc().findGdc();
    }

    public int findGdc(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a > b) {
            return findGdc(a % b, b);
        }
        else return findGdc(a, b % a);

//        without recursive
//        while (true) {
//            if (a == 0) {
//                return b;
//            }
//            if (b == 0) {
//                return a;
//            }
//            if (a > b) {
//                a %= b;
//            }
//            else b %= a;
//        }
    }
}