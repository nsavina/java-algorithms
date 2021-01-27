import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Backpack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] sA = s.split(" ");
        int amount = Integer.parseInt(sA[0]);
        int backpackVolume = Integer.parseInt(sA[1]);

        ArrayList<Item> l = new ArrayList<>();

        float res = 0;

        for (int i = 0; i < amount; i++) {
            String str = reader.readLine();
            String[] strA = str.split(" ");
            int cost = Integer.parseInt(strA[0]);
            int volume = Integer.parseInt(strA[1]);
            if (cost != 0) {
                Item item = new Item(cost, volume);
                l.add(item);
            }
        }

//        Item[] ar = new Item[5];
//
//        Arrays.sort(ar, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return Double.compare((double) o2.cost / o2.volume, (double) o1.cost / o1.volume);
//            }
//        });

        Comparator<Item> comparator = (obj1, obj2) -> Double.compare((double) obj2.cost / obj2.volume, (double) obj1.cost / obj1.volume);
        l.sort(comparator);

        int i = 0;
        while(i < l.size()) {
            int volume = l.get(i).volume;
            int cost = l.get(i).cost;
            if (volume <= backpackVolume) {
                res += cost;
                backpackVolume -= volume;
                if (backpackVolume == 0) {
                    break;
                }
            }
            else {
                float partCost = (float) backpackVolume * cost / volume;
                res += partCost;
                break;
            }
            i++;
        }

        System.out.format("%.3f", res * 1.000);
    }

    public static class Item implements Comparable<Item> {
        int cost;
        int volume;

        public Item(int cost, int volume) {
            this.cost = cost;
            this.volume = volume;
        }


        @Override
        public int compareTo(Item o) {
            return Double.compare((double) o.cost / o.volume, (double) cost / volume);
        }
    }
}
