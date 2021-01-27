import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public static int binarySearch(ArrayList<Integer> l, int k) {
        int left = 0;
        int right = l.size() - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int val = l.get(mid);
            if (val == k) {
                return mid + 1;
            }
            else if (val > k) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] sA = s.split(" ");
        int arraySize = Integer.parseInt(sA[0]);

        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 1; i < arraySize + 1; i++) {
            l.add(Integer.parseInt(sA[i]));
        }

        Collections.sort(l);


        String sk = reader.readLine();
        String[] skA = sk.split(" ");
        int arrayKSize = Integer.parseInt(skA[0]);

        ArrayList<Integer> lk = new ArrayList<>();

        for (int i = 1; i < arrayKSize + 1; i++) {
            lk.add(Integer.parseInt(skA[i]));
        }

        for (Integer integer : lk) {
            System.out.print(binarySearch(l, integer) + " ");
        }

    }
}
