import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DifferentTerms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if ((n - i) >= (i + 1)) {
                n -= i;
                l.add(i);
            }
            else {
                l.add(n);
                break;
            }
        }

        System.out.println(l.size());
        for (Integer i :
                l) {
            System.out.print(i + " ");
        }
    }
}
