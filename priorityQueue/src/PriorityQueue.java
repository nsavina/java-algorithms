import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandAmount = Integer.parseInt(reader.readLine());

        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < commandAmount; i++) {
            String str = reader.readLine();
            String[] helpArr = str.split(" ");
            String command = helpArr[0];

            if (command.equals("Insert")) {
                int priority = Integer.parseInt(helpArr[1]);
                insertElement(a, priority);
            }
            else if (command.equals("ExtractMax")) {
                extractMax(a);
            }
        }
    }

    public static void insertElement(ArrayList<Integer> a, Integer newEl) {
        a.add(newEl);
        if (a.size() > 1) {
            int i = a.size() - 1;
            while (true) {
                if (i == 0) {
                    break;
                }
                else if (newEl > a.get((i + 1) / 2 - 1)) {
                    int copy = a.get(i);
                    a.set(i, a.get((i + 1) / 2 - 1));
                    a.set((i + 1) / 2 - 1, copy);
                    i = (i + 1) / 2 - 1;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(a);
    }

//8
//Insert 2
//Insert 3
//Insert 15
//Insert 18
//Insert 12
//ExtractMax

    public static void extractMax(ArrayList<Integer> a) {
        System.out.println(a.get(0));
        a.set(0, a.get(a.size() - 1));
        a.remove(a.size() - 1);
        System.out.println(a);
        int i = 0;
        if (a.size() > 2) {
            while (true) {
                if (2 * i + 1 > a.size() - 1) {
                    break;
                }
                else if (2 * i + 2 > a.size() - 1) {
                    if (a.get(i) < a.get(2 * i + 1)) {
                        int copy = a.get(i);
                        a.set(i, a.get(2 * i + 1));
                        a.set(2 * i + 1, copy);
                        i = 2 * i + 1;
                    }
                    else {
                        break;
                    }
                }
                else if (a.get(i) < a.get(2 * i + 1) || a.get(i) < a.get(2 * i + 2)) {
                    int maxI = a.get(2 * i + 1) > a.get(2 * i + 2) ? (2 * i + 1) : (2 * i + 2);
                    int copy = a.get(i);
                    a.set(i, a.get(maxI));
                    a.set(maxI, copy);
                    i = maxI;
                    System.out.println(a);
                    System.out.println(i);
                } else {
                    break;
                }
            }
        }
        else if (a.size() > 1) {
            if (a.get(0) < a.get(1)) {
                int copy = a.get(0);
                a.set(0, a.get(1));
                a.set(1, copy);
            }
        }

        System.out.println(a);

    }
}
