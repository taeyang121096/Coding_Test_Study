package SWEA;

import java.io.*;

public class SW_1217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int pow = getPow(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            System.out.println("#" + N + " " + pow);
        }
    }

    public static int getPow(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a * getPow(a, b - 1);
        }
    }
}
