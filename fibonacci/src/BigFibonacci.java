import java.util.Scanner;

public class BigFibonacci {
    public static void main(String[] args) {
        // put your code here\\
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 100000;
        }
        System.out.println(a[n] % m);
    }
}