package BaekJun;

import java.io.*;
import java.util.*;

/**
 * 리모컨 버튼 : 0~9, + -
 * 이동하려는 채널은 N, 채널 N으로 이동하기 위해서 최소 버튼을 몇번 눌러야 하는가
 * 5457, 100 -> 5355 + 2 +
 */
public class B1107 {
    public static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()); // 5457
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()); // 3
        int M = Integer.parseInt(st.nextToken());

        // 누를 수 없는 리모컨 버튼을 true로 변경
        check = new boolean[10];
        if (M != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                check[num] = true;
            }
        }

        if (N == 100) {
            System.out.println(0);
            return;
        }

        int min_cnt = Math.abs(N - 100);    // +,- 로만 누르는 경우

        for (int i = 0; i <= 1000000; i++) {
            int len = check(i);   // 숫자버튼 누르는 횟수
            if (len > 0) {
                /**
                 * 결국 원래 숫자에서 가장 가까운 숫자를 뺴 주는건 필수이고,
                 * 거기서 +나 -를 눌러서 그 숫자에 다가가는 거랑
                 * 최대 최소 비교를 해준다.
                 * check() 함수에서 뺄 수 있는 숫자들을 찾아주기 때문에, 이렇게 가능함
                 */
                int press = Math.abs(N - i);  // +,- 버튼 누르는 횟수
                min_cnt = Math.min(min_cnt, len + press);   // 최소 이동 횟수 계산
            }
        }

        System.out.println(min_cnt);
    }

    public static int check(int n) {
        // n = 0일때 사용가능한 리모콘버튼이라면 1, 아니면 0
        if (n == 0) {
            if (check[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;

        while (n > 0) {
            if (check[n % 10]) {   // 고장난 버튼이 있는 경우
                return 0;
            }
            n /= 10;
            len += 1;   // 숫자버튼 누르는 횟수 증가
        }

        return len;
    }
}
