package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_11285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                double distance = Math.sqrt(x * x + y * y);

                if (distance == 0) {
                    sum += 10;
                } else {
                    for (int j = 1; j <= 10; j++) {
                        if (20 * (11 - j) >= distance && 20 * (11 - j - 1) < distance) {
                            sum += j;
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
