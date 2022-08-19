package SW;

import java.io.*;
import java.util.*;

public class SW_1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] str = br.readLine().split(" "); // #1
            int N = Integer.parseInt(str[1]);// 7041

            String[] s = br.readLine().split(" "); // test case
            int[] map = new int[s.length];
            for (int j = 0; j < N; j++) {
                if(s[j].equals("ZRO")){
                    map[j] = 0;
                } else if(s[j].equals("ONE")) {
                    map[j] = 1;
                } else if(s[j].equals("TWO")) {
                    map[j] = 2;
                } else if(s[j].equals("THR")) {
                    map[j] = 3;
                } else if(s[j].equals("FOR")) {
                    map[j] = 4;
                } else if(s[j].equals("FIV")) {
                    map[j] = 5;
                } else if(s[j].equals("SIX")) {
                    map[j] = 6;
                } else if(s[j].equals("SVN")) {
                    map[j] = 7;
                } else if(s[j].equals("EGT")) {
                    map[j] = 8;
                } else if(s[j].equals("NIN")){
                    map[j] = 9;
                }
            }
            Arrays.sort(map);

            sb.append(str[0]).append("\n");
            for (int j = 0; j < N; j++) {
                if(map[j] == 0){
                    sb.append("ZRO ");
                } else if(map[j] == 1) {
                    sb.append("ONE ");
                } else if(map[j] == 2) {
                    sb.append("TWO ");
                } else if(map[j] == 3) {
                    sb.append("THR ");
                } else if(map[j] == 4) {
                    sb.append("FOR ");
                } else if(map[j] == 5) {
                    sb.append("FIV ");
                } else if(map[j] == 6) {
                    sb.append("SIX ");
                } else if(map[j] == 7) {
                    sb.append("SVN ");
                } else if(map[j] == 8) {
                    sb.append("EGT ");
                } else if(map[j] == 9){
                    sb.append("NIN ");
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
