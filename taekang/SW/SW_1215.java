package SW;

import java.io.*;
import java.util.*;

public class SW_1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            int N = Integer.parseInt(br.readLine()); // 4
            char[][] map = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    map[i][j] = str.charAt(j);
                }
            }

//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(map[i][j]+"");
//                }
//                System.out.println();
//            }

            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                for (int i = 0; i <= 8 - N; i++) { // i <= 4, 01234
                    String str = "";
                    for (int j = i; j < N + i; j++) { // j = 1, j < 5
                        str += map[k][j];
                    }
                if(isPalindrome(str))
                    cnt++;
                }
            }

            for (int k = 0; k < 8; k++) {
                for (int i = 0; i <= 8 - N; i++) { // i <= 4, 01234
                    String str = "";
                    for (int j = i; j < N + i; j++) { // j = 1, j < 5
                        str += map[j][k];
                    }
                if(isPalindrome(str))
                    cnt++;
                }
            }
            System.out.println("#" + T + " " + cnt);
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
