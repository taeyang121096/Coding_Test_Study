import java.util.*;
import java.io.*;

public class StringBomb_BOJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();

        List<Character> al = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            al.add(str.charAt(i));
            if (al.size() >= bomb.length()) {
                boolean flag = true;
                    for (int j = 0; j < bomb.length(); j++) {
                        if (al.get(al.size() - bomb.length() + j) != bomb.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int k = 0; k < bomb.length(); k++) {
                        al.remove(al.size() - 1);
                    }
                }
            }
        }
        for (int i = 0; i < al.size(); i++) {
            sb.append(al.get(i));
        }
        if (sb.toString().length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
