//Дано число 1 ≤ n ≤ 10^7, необходимо найти последнюю цифру n-го числа Фибоначчи.

import java.util.Scanner;

public class FibonacciLastNumber {
    public static void main(String[] args) {
        // put your code here\\
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
                a[i] = (a[i - 1] + a[i - 2]) % 10;
            }
            System.out.println(a[n]);
        }
    }
}