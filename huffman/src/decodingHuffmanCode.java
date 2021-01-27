import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class decodingHuffmanCode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sAmount = reader.readLine();
        String[] helpArr = sAmount.split(" ");
        int letters = Integer.parseInt(helpArr[0]);
        int bytes = Integer.parseInt(helpArr[1]);

        ArrayList<Coding> a = new ArrayList<>();

        for (int i = 0; i < letters; i++) {
            String s = reader.readLine();
            String[] helpA = s.split(" ");
            String letter = helpA[0];
            String code = helpA[1];
            Coding coding = new Coding(letter.charAt(0) + "", code);
            a.add(coding);
        }

        String codedString = reader.readLine();
        String part = "";

        String decodedString = "";

        while (!codedString.equals("")) {
            part += codedString.charAt(0);
            codedString = codedString.substring(1);
            for (Coding c :
                    a) {
                if (c.code.equals(part)) {
                    decodedString += c.ch;
                    part = "";
                }

            }
        }

        System.out.println(decodedString);

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
