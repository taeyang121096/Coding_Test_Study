package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_12368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int Time = A + B;
            if (Time >= 24) {
                Time -= 24;
            }
            System.out.println("#" + tc + " " + Time);
        }
    }
}
