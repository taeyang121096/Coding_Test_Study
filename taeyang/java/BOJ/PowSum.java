package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PowSum {

    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            D[i] = i;
            for (int j = 1; j * j <= i; j++) D[i] = Math.min(D[i], D[i - j * j] + 1);
        }
        System.out.print(D[N]);
    }


}
