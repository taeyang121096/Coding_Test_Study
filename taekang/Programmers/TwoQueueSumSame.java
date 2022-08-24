//import java.util.*;
//class Solution {
//    public int solution(int[] queue1, int[] queue2) {
//        int answer = 0;
//        Queue<Integer> q1 = new ArrayDeque<>();
//        Queue<Integer> q2 = new ArrayDeque<>();
//
//        long q1_sum = 0;
//        for(int i = 0; i < queue1.length; i++){
//            q1.offer(queue1[i]); // 3 2 7 2
//            q1_sum += queue1[i];
//        }
//
//        long q2_sum = 0;
//        for(int i = 0; i < queue2.length; i++){
//            q2.offer(queue2[i]); // 3 2 7 2
//            q2_sum += queue2[i];
//        }
//
//        // 절반 구하기
//        long sum = 0;
//        for(int i = 0; i < queue1.length; i++){
//            sum += queue1[i] + queue2[i];
//        }
//        long half = sum / 2;
//
//        // Greedy
//        while(true){
//            if(q1_sum < q2_sum){
//                int t = q2.poll();
//                q1.offer(t); // q2.offer()
//                q2_sum -= t;
//                q1_sum += t;
//                answer++;
//            } else if(q2_sum < q1_sum){
//                int t = q1.poll();
//                q2.offer(t);
//                q1_sum -= t;
//                q2_sum += t;
//                answer++;
//            }
//
//            if(q1_sum == q2_sum){ // 15 && 15
//                break;
//            }
//
//            if(q1.isEmpty() || q2.isEmpty()){
//                answer = -1;
//                break;
//            }
//            // 1 1 1 1 1 1 15 1
//            // 1 1 1 1 1 1 1  1
//            if(answer > queue1.length*3 - 3){
//                answer = -1;
//                break;
//            }
//        }
//
//
//        return answer;
//    }
//}