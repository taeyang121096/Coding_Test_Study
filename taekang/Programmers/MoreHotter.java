///**
// 모든 음식의 스코빌 지수 K 이상
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
// **/
//import java.util.*;
//class Solution {
//    public int solution(int[] scoville, int K) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//
//        int answer = 0;
//
//        for(int i = 0; i < scoville.length; i++){
//            q.offer(scoville[i]);
//        }
//
//        while(!q.isEmpty() && q.size() > 0){
//            if(q.size() == 1){
//                return -1;
//            } else{
//                q.offer(q.poll() + q.poll()*2);
//                answer++;
//                if(q.peek() >= K)
//                    break;
//            }
//
//        }
//
//        return answer;
//    }
//}