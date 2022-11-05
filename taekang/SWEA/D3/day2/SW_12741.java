package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_12741 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int a = Integer.parseInt(st.nextToken()); // 1
            int b = Integer.parseInt(st.nextToken()); // 3
            int c = Integer.parseInt(st.nextToken()); // 5
            int d = Integer.parseInt(st.nextToken()); // 7

            max = Math.max(a, c);
            min = Math.min(b, d);

            System.out.print("#" + tc + " ");
            if (max > min) {
                System.out.println("0");
            } else {
                System.out.println(min-max);
            }
        }
    }
}
