package BaekJun.BruteForce;

import java.io.*;

public class B1003_fibonacci {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 3

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine()); // 0, 1, 3
            int[][] arr = new int[n + 1][2];

            if (n == 0) {
                System.out.println("1 0");
            } else if (n == 1) {
                System.out.println("0 1");
                //continue;
            } else {
                arr[0][0] = 1;
                arr[1][1] = 1;

                for (int j = 2; j <= n; j++) {
                    arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
                    arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
                }
                System.out.println(arr[n][0] + " " + arr[n][1]);
            }
        }
    }
}
