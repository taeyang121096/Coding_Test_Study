package BaekJun;

import java.io.*;
import java.util.*;

public class B17299_OthBigNum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // T = 7
        int T = Integer.parseInt(br.readLine());

        // 필요요소들 선언
        Deque<Integer> stack = new ArrayDeque<>();


        // 1 1 2 3 4 2 1
        String input = br.readLine();
        String[] s = input.split(" ");
        int[] val = new int[T];
        int[] ans = new int[T];

        int max = -1;
        for (int i = 0; i < T; i++) {
            val[i] = Integer.parseInt(s[i]);
            if (max < val[i]) {
                max = val[i];
            }
        }

        int[] count = new int[max];

        for (int i = 0; i < T; i++) {
            val[i] = Integer.parseInt(s[i]);
            count[val[i] - 1] += 1;
        }

        for (int i = 0; i < T; i++) {
            while (!stack.isEmpty() && count[val[stack.peek()] - 1] < count[val[i] - 1]) {
                ans[stack.pop()] = val[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for (int i = 0; i < T; i++)
            sb.append(ans[i] + " ");

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
