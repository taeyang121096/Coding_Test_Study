package BaekJun;

import java.io.*;
import java.util.*;

public class B1158_Josephus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        String[] arr = input.split(" ");
        int T = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        Queue<Integer> queue = new LinkedList<>();

        // Queue 요소 초기화
        for (int i = 0; i < T; i++) {
            queue.add(i + 1);
        }

        bw.write("<");

        /**
         * 문제를 푼 방법
         * 1 2 3 4 5 6 7 에서 K=3번째 숫자까지 빼주고 뒤로 넣어주고 만들어진 배열에서 k=3번째 숫자까지 빼주고 뒤로 넣어주고를 반복.
         * k= 1, 2번째 숫자들은 값을 출력하지 않고 poll() 로 빼서 다시 add()해 줌.
         *
         * ex)
         * 1 2 3 4 5 6 7, K = 3 --> 1, 2, (3) 세개 다 poll(), 값은 (3) 출력
         * 4 5 6 7 1 2, k = 3 --> 4, 5, (6)
         * 7 1 2 4 5, k = 3 --> 7, 1, (2)
         * 4 5 7 1, k = 3 --> 3, 4, (7)
         * 1 4 5, k = 3 --> 6, 7, (5)
         * 1 4, k = 3 --> 2, 3, (1)
         * (4)
         */

        for (int i = 0; i < T; i++) {
            // 마지막 반복 때 ,를 추가하지 않기 위해서 if-else 문을 이용해 구분함.
            if (i == T - 1) {
                for (int j = 0; j < K; j++) {
                    // K번째 값을 출력해주기 위해서 if-else 문을 이용해 구분함.
                    if (j == K - 1)
                        bw.write(queue.poll()+"");
                    else {
                        Integer poll = queue.poll();
                        queue.add(poll);
                    }
                }
            } else {
                for (int j = 0; j < K; j++) {
                    if (j == K - 1)
                        bw.write(queue.poll() + ", ");
                    else {
                        Integer poll = queue.poll();
                        queue.add(poll);
                    }
                }
            }
        }

        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}
