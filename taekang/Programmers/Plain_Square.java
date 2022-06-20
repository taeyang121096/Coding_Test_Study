package Programmers;

import java.util.*;

class Solution {
    public long solution(int w, int h) {
        // 가로 : W, 세로 : H
        long W = Long.valueOf(w);
        long H = Long.valueOf(h);
        if(W == H){
            return W*H-W;
        } else if (W == 1 || H == 1){
            return 0;
        } else {
            long gcd_ans = gcd(W, H);
            long answer = (W * H) - (((W / gcd_ans) + (H / gcd_ans)-1) * gcd_ans);
            return answer;
        }

        // 가로 세로를 더이상 나눌수 없는 소수까지 인수분해를 실시하고, 그거에 해당하는 거의 사용 불가능한 애를 구한담에
        // 가로 세로까지 몇 곱해야하나,...
        // 반복은 최대 공약수 만큼 반복이 진행됨
        //(w * h) - (((w / gcd) + (h / gcd) - 1) * gcd)를 리턴한다
    }

    // 최대공약수를 구하는 메소드인 gcd
    private static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}