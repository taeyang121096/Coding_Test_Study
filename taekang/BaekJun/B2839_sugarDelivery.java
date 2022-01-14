package BaekJun;

import java.util.*;

public class B2839_sugarDelivery {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        // 5개의 갯수가 많을 수록 최소의 개수가 나올 것이다
        int five_num = num / 5;
        System.out.println(DP(num, five_num));
    }

    public static int DP(int number, int five_num) {
        // 종료 조건
        if(five_num < 0)
            return -1;

        // 알고리즘 진행, three 로 나누어 떨어지지 않으면 5kg의 설탕 봉지를 하나 줄여줌, 그런 다음 three 가 사용될 수 있는지 판별한다
        int three = (number - (five_num * 5)) / 3;
        if(number - (five_num *  5) - (three * 3) == 0){
            return five_num + three;
        }
        return DP(number, five_num - 1);
    }
}
