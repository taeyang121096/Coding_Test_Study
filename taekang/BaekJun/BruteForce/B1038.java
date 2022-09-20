package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B1038 {
    public static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n <= 10) {
            System.out.println(n);
        } else if (n > 1022) {
            System.out.println(-1);
        } else {
            for (long i = 0; i < 10; i++) {
                calc(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    private static void calc(long num, int depth) {
        if (depth > 10) {
            return;
        }
        list.add(num);
        // 2 20 21
        // 3 || 30 31 32 || 310 320 321
        for (int i = 0; i < num % 10; i++) {
            calc((num * 10) + i, depth + 1);
        }
    }
}
