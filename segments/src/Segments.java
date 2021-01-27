import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Segments {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(reader.readLine());

        ArrayList<Segment> l = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            String s = reader.readLine();
            String[] sA = s.split(" ");
            int beg = Integer.parseInt(sA[0]);
            int end = Integer.parseInt(sA[1]);
            Segment seg = new Segment(beg, end);
            l.add(seg);
        }

//        for (Segment s :
//                l) {
//            System.out.println(s.begin + " " + s.end);
//        }

        Comparator<Segment> comparator = Comparator.comparing(obj -> obj.end);
        l.sort(comparator);


        int count = 1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(l.get(0).end);
        int i = 1;
        while(i < l.size()) {
            if (l.get(i).begin <= res.get(count - 1)) {
                i++;
            }
            else {
                count++;
                res.add(l.get(i).end);
                i++;
            }
        }

        System.out.println(count);

        for (int j :
                res) {
            System.out.print(j + " ");
        }


    }

    public static class Segment {
        int begin;
        int end;

        public Segment(int beg, int end) {
            this.begin = beg;
            this.end = end;
        }
    }
}
