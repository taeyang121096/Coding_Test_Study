package SW;

import java.io.*;
import java.util.*;

public class SW_1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[100][100];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            int cnt = 0;
            for (int k = 0; k < 100; k++) { // k = 0
                for (int len = 1; len <= 100; len++) { // len 1
                    for (int i = 0; i <= 100 - len; i++) { // i =0,  i <= 99
                        String str = "";
                        for (int j = i; j < len + i; j++) { // j = 0, j < 1
                            str += map[k][j];
                        }
                    if(isPalindrome(str))
                        max = Math.max(max, str.length());
                    }
                }

            }

            for (int k = 0; k < 100; k++) {
                for (int len = 1; len <= 100; len++) {
                    for (int i = 0; i <= 100 - len; i++) { // i <= 4, 01234
                        String str = "";
                        for (int j = i; j < len + i; j++) { // j = 1, j < 5
                            str += map[j][k];
                        }
                        if(isPalindrome(str))
                            max = Math.max(max, str.length());
                    }
                }
            }
            System.out.println("#" + T + " " + max);
        }
    }
    public static boolean isPalindrome(String str) {
        int N = str.length();
        for (int i = 0; i < N / 2; i++) {
            if (!(str.charAt(i) == str.charAt(N - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
