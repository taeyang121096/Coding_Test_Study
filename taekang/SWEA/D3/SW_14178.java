package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_14178 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] str= br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int D = Integer.parseInt(str[1]);

            int len = 2 * D + 1;
            int result = N / len;
            if (N % len > 0) {
                result++;
            }
            System.out.println("#" + i + " " + result);
        }
    }
}
