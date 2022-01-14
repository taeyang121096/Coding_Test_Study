package BaekJun;

import java.io.*;

public class B9095_plus123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(DP(number));
        }

        /**
         * DP(1) = 1 -> 1
         * DP(2) = 1+1 , 2 -> 2(+1)
         * DP(3) = 1+1+1, 1+2, 3  -> 4(+2)
         * DP(4) = 1+1+1+1 , 1+1+2, 1+3, 2+2 -> 7(+3)
         * DP(5) = 1+1+1+1+1, 1+1+1+2, 1+1+3, 1+2+2, 2+3 -> 13(+5)
         * DP(6) = 1+1+1+1+1+1, 1+1+1+1+2, 1+1+2+2, 2+2+2,  1+1+1+3, 1+2+3, 3+3->  24(+11)
         * DP(7) = 44(+20)
         *
         * DP(n) = DP(n-1) + DP(n-2) + DP(n-3)
         */
    }

    public static int DP(int number) {
        // 종료 조건
        if(number == 1)
            return 1;
        if(number == 2)
            return 2;
        if(number == 3)
            return 4;
        // 재귀
        return DP(number - 1) + DP(number - 2) + DP(number - 3);
    }
}
