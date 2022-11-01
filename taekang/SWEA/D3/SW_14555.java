package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_14555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    if (str.charAt(j + 1) == ')' || str.charAt(j + 1) == '|') {
                        cnt++;
                    }
                } else if (str.charAt(j) == ')') {
                    if (str.charAt(j - 1) == '|') {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + i + " " + cnt);
        }
    }
}
