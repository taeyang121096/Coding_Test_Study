import java.util.*;

class Solution {
    static int isPrime(int n){
        if(n==1)
            return 0;
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i==0&&n/i<=10000000)
                return n/i;
        }
        return 1;
    }
    public int[] solution(long begin, long end) {
        int b = (int)begin;
        int e = (int)end;
        int[] answer = new int[e-b+1];
        int cnt = 0;
        
        for(int n = b; n<=e; n++){
            answer[cnt++] = isPrime(n);
        }
        return answer;
    }
}