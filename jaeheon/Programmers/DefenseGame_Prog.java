package Programmers;

import java.util.*;

public class DefenseGame_Prog {
	public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 4 6 10
        // 4 2 4
        for(int i = 0; i < enemy.length; i++){
            sum += enemy[i];
            if(sum <= n){
                pq.offer(enemy[i]*(-1));
                // System.out.println(sum + " " + "1번째" + " " + enemy[i] + " " + i);
                answer++;
            } else if(k > 0){
                k--;
                pq.offer(enemy[i]*(-1));
                // System.out.println(pq.peek() + "  " + pq.size());
                sum += pq.poll();
                // System.out.println(sum + " " + "2번째" + " " + enemy[i] + " " + i);
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
