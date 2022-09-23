package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B12919 {
    public static String S, T;
    public static int len;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(S, T);
        if (cnt > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                cnt++;
            }
            return;
        }
        // A를 추가하는 방식 -> A를 삭제하는 방식
        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, new StringBuilder().append(t).substring(0, t.length() - 1));
        }
        // B를 추가하고 문자열을 뒤집는 방식 -> 문자열을 뒤집고 B를 삭제하는 방식
        if (t.charAt(0) == 'B') {
            dfs(s, new StringBuilder().append(t).reverse().substring(0, t.length() - 1));
        }
    }
}
