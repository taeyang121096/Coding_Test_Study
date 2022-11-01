package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_14692 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            recur(N);
        }
    }

    private static void recur(int Num) { // 5
        if (Num == 1) {
            return;
        } else {
            int a = Num / 2; // 2
            int b = Num / 2 + 1; // 3
            recur(a); // 2 - 1, 1
            recur(b); // 3 - 1, 2
        }

    }
}
