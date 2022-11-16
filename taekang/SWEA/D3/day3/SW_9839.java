package SWEA.D3.day3;

import java.io.*;
import java.util.*;

/**
 * N개의 양의 정수가 주어졌을 때, 정확히 서로 다른 두 개의 정수 쌍을 고르려고 함
 * <p>
 * x,y 라고 하면 x*y 는 10진수를 읽었을 때 증가하면서도 연속한 숫자들로 이루어져야 함
 * <p>
 * 두 정수의 곱이 최대화되는 쌍을 최고의 쌍 이라고 한다.
 */
public class SW_9839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ArrayList<Integer> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int mul = list.get(i) * list.get(j);
                    ArrayList<Integer> l = new ArrayList<>();

                    while (mul > 0) {
                        int d = mul % 10;
                        l.add(d);
                        mul = mul / 10;
                    }
                    mul = list.get(i) * list.get(j);

                    boolean flag = true;
                    for (int k = 0; k < l.size() - 1; k++) {
                        if (l.get(k)  != l.get(k + 1) + 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        max = Math.max(max, mul);
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                System.out.println("#" + tc + " " + -1);
            } else {
                System.out.println("#" + tc + " " + max);
            }

        }
    }
}
