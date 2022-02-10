package Programmers;

import java.util.*;

class Immigration_Prog {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long min = 1;
        long max = (long)times[times.length-1] * n;
        
        while(max >= min){
            long mid = (min + max) / 2;
            long cnt = 0;
            for(int i = 0; i < times.length; i++){
                cnt += mid/times[i];
            }
            if(n > cnt){
                min = mid + 1; // 범위 줄임
            } else {
                max = mid - 1; // 범위 줄임
                answer = mid;
            }
        }
        
        return answer;
    }
}