package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_13428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String num = br.readLine();
            char[] c = num.toCharArray();

            int min = Integer.parseInt(String.valueOf(c)); // 12345
            int max = min; // 12345

            for (int i = 0; i < num.length(); i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    char tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;
                    if (c[0] != 48) {
                        max = Math.max(max, Integer.parseInt(String.valueOf(c)));
                    }
                    if (c[0] != 48) {
                        min = Math.min(min, Integer.parseInt(String.valueOf(c)));
                    }
                    tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;
                }
            }
            System.out.printf("#%d %d %d\n", t, min, max);
        }
    }
}
