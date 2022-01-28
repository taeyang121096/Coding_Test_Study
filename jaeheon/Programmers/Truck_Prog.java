package Programmers;

//다리 길이 1 ~ 10000
//다리 견디는 무게 1 ~ 10000
//트럭 무게 1 ~ 10000
//대기 트럭 순서대로 -> 큐
//1초에 한 트럭씩 진입 가능

import java.util.*;

class Truck_Prog {
 public int solution(int bridge_length, int weight, int[] truck_weights) {
     int answer = 0;
     int sum = 0; // 다리 건너는 트럭 무게 합
     
     Queue<Integer> q = new ArrayDeque<>();
     
     for(int tmp : truck_weights){
         while(true){
             //큐가 비어있을 때
             if(q.isEmpty()){
                 q.offer(tmp);
                 sum+=tmp;
                 answer++;
                 break;    
             }
             // 큐의 사이즈와 다리 길이 같을 때
             else if(q.size() == bridge_length){
                 sum -= q.poll();
             } 
             // 큐가 비어있지 않을 때
             else {
                 // 다음 트럭 무게 초과
                 if(sum + tmp > weight){
                     q.offer(0);
                     answer++;
                 }
                 // 무게 이내
                 else{
                     q.offer(tmp);
                     sum+=tmp;
                     answer++;
                     break;
                 }
             }
         }
     }
     
     return answer+bridge_length;
 }
}