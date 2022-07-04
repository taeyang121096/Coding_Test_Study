import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int head = 0;
        int tail = people.length-1;
        
        while(head <= tail){
            if(people[head] + people[tail] <=limit){
                head++;
            }
            tail--;
            answer++;
        }
        return answer;
    }
}