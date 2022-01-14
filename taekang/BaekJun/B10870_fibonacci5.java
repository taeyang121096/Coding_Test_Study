package BaekJun;

import java.util.*;

public class B10870_fibonacci5 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        sum += DP(num);
        System.out.println(sum);
    }

    public static int DP(int number) {
        // 종료 조건
        if(number == 0)
            return 0;
        if(number == 1)
            return 1;
        // 재귀
        return DP(number - 1) + DP(number - 2);
    }
}
