//Дано целое число 1 ≤ n ≤ 40, необходимо вычислить n-е число Фибоначчи

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        // put your code here\\
        long startTime = System.currentTimeMillis();
        new Fibonacci().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + "ms");
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        else {
            int[] a = new int[n + 1];
            a[0] = 0;
            a[1] = 1;
            for (int i = 2; i <= n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            System.out.println(a[n]);

//            int a = 0;
//            int b = 1;
//            for (int i = 0; i < n; i++) {
//                int c = a + b;
//                a = b;
//                b = c;
//            }
//            System.out.println(a);
        }
    }
}