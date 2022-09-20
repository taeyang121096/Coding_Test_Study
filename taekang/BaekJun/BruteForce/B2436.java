package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken()); // 6
        int lcm = Integer.parseInt(st.nextToken()); // 180

        int tmp = lcm / gcd; // 30의 약수

        // 30의 약수 중에서 서로소 여야함

        int gcdA = 0, gcdB = 0;
        for (int i = 1; i * i <= tmp; i++) {
            if (tmp % i == 0) {
                int a = i;
                int b = tmp / i;
                if (gcd(a, b) == 1) {
                    gcdA = a * gcd;
                    gcdB = b * gcd;
                }
            }
        }
        System.out.println(gcdA + " " + gcdB);
    }

    public static int gcd(int a, int b) {
        // 큰숫자를 작은숫자로 나눈 나머지를 계산
        int r = a % b;
        // 나머지가 0이면 작은숫자가 최대공약수이므로 작은숫자 리턴
        if (r == 0) {
            return b;
        } else {
            // 나머지가 0 이상이면 재귀형태로 호출
            // 이때 파라미터는 작은숫자와 나머지를 넣어줌
            return gcd(b, r);
        }
//        return a%b == 0 ? b: getGCD(b, a%b);
    }
}
