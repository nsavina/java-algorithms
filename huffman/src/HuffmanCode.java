import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class HuffmanCode {
    public static void main(String[] args) throws IOException {
        // put your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            if (!m.containsKey(ch)) {
                m.put(ch, 1);
            }
            else {
                int oldValue = m.get(ch);
                m.replace(ch, ++oldValue);
            }
        }

        ArrayList<Frequency> frequencyList = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : m.entrySet()) {
            Frequency el = new Frequency(pair.getKey(), pair.getValue());
            frequencyList.add(el);
        }

        int n = frequencyList.size();

        Comparator<Frequency> comparator = Comparator.comparingInt(obj -> obj.fr);
        frequencyList.sort(comparator);

        ArrayList<Coding> helpList = new ArrayList<>();

        for (int i = n + 1; i < (2 * n - 1); i++) {
            frequencyList.sort(comparator);
            Frequency min1 = frequencyList.get(0);
            Frequency min2 = frequencyList.get(1);
            Frequency newPeak = new Frequency(min1.ch + min2.ch, min1.fr + min2.fr);
            frequencyList.add(newPeak);
            helpList.add(new Coding(min1.ch, "0"));
            helpList.add(new Coding(min2.ch, "1"));
            frequencyList.remove(0);
            frequencyList.remove(0);
        }

        if (frequencyList.size() == 1) {
            Frequency min1 = frequencyList.get(0);
            helpList.add(new Coding(min1.ch, "0"));
        }
        else if (frequencyList.size() >= 1) {
            Frequency min1 = frequencyList.get(0);
            helpList.add(new Coding(min1.ch, "0"));

            Frequency min2 = frequencyList.get(1);
            helpList.add(new Coding(min2.ch, "1"));
        }

        ArrayList<Coding> resList = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : m.entrySet()) {
            String res = "";
            for (Coding c :
                    helpList) {
                if (c.ch.contains(pair.getKey())) {
                    res += c.code;
                }
            }
            res = new StringBuilder(res).reverse().toString();
            resList.add(new Coding(pair.getKey(), res));
        }

//        for (Frequency f :
//                l) {
//            System.out.println(f.ch + " " + f.fr);
//        }
//
//        System.out.println();
//
//        for (Coding c :
//        cL) {
//            System.out.println(c.ch + " " + c.code);
//        }
//
//        System.out.println();
//
//        for (Coding c :
//                resList) {
//            System.out.println(c.ch + " " + c.code);
//        }

        String resCode = "";

        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            for (Coding c :
                    resList) {
                if (c.ch.equals(ch)) {
                    resCode += c.code;
                }
            }
        }

        System.out.println(resList.size() + " " + resCode.length());

        for (Coding c :
                resList) {
            System.out.println(c.ch + ": " + c.code);
        }

        System.out.println(resCode);
    }

    static class Frequency {
        final String ch;
        final Integer fr;

        public Frequency(String ch, Integer fr) {
            this.ch = ch;
            this.fr = fr;
        }
    }

    static class Coding {
        final String ch;
        final String code;

        public Coding(String ch, String code) {
            this.ch = ch;
            this.code = code;
        }
    }
}