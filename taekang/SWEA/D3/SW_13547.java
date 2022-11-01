package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_13547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            int N = str.length();
            int Mid = 15 / 2;
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'x') {
                    cnt++;
                }
            }
            int pos = 15 - cnt; //
            System.out.print("#" + i + " ");
            if (pos > Mid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
