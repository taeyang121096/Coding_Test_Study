import java.util.*;
public class Prime_Pro {

    static boolean prime(int n){
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    class Solution {

        public int solution(int n) {
            int answer = 0;

            for(int i =2;i<=n;i++){
                if(prime(i))
                    answer++;
            }
            return answer;
        }
    }
}
