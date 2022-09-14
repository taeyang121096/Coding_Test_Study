package BaekJun;

import java.io.*;
import java.util.*;

/**
 * 암호는 서로 다른 L개의 알파벳 소문자, 최소 한개의 모음과 최소 두개의 자음
 * 알파벳이 암호에서 증가하는 순으로 배열, 즉 조합이다.
 */
public class B1759 {
    public static int L, C;
    public static char[] list, code;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        check = new boolean[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0);
        }
        // 정렬

        Arrays.sort(list);
        // L개 중에서 4개를 뽑는 모든 조합을 찾는다
        dfs(0, 0);
    }

    public static void dfs(int x, int idx) {
        if (idx == L) {
            if (isValid())
                System.out.println(code);
            return;
        }

        for (int i = x; i < C; i++) {
            if (!check[i]) {
                check[i] = true;
                code[idx] = list[i];
                dfs(i + 1, idx + 1);
                check[i] = false;
            }
        }
    }

    private static boolean isValid() {
        int mo = 0;
        int ja = 0;
        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}
