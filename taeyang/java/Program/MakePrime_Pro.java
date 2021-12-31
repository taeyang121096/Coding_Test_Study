import java.util.*;
public class MakePrime_Pro {
    static int answer;
    static int[] Num;
    static boolean check(int num){

        for(int i =2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    static void make(int depth,int start,int sum){
        if(depth == 3){
            if(check(sum))
                answer++;
            return;
        }
        for(int i = start;i<Num.length;i++){
            make(depth+1,i+1,sum+Num[i]);
        }

    }
    class Solution {

        public int solution(int[] nums) {
            answer =0;
            Num = nums;
            make(0,0,0);

            return answer;
        }
    }
}
