package BaekJun;

import java.io.*;
import java.util.*;

public class B1874_stackSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장

        Stack<Integer> stack = new Stack<>();
        int start = 0;

        int N = Integer.parseInt(br.readLine()); // 8
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());

            if (M > start) { // M이 start보다 클 때만 가능
                for (int j = start + 1; j <= M; j++) { // start 가 0이라면 1~4까지 push,
                    stack.push(j);
                    sb.append('+').append('\n');	// + 를 저장한다.
                }
                start = M; // start를 M으로 바꿔줌
            } else if (stack.peek() != M) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
