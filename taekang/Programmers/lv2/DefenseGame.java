///**
// 병사 n 명으로 적의 공격을 순서대로 막는 게임입니다.
//
// 매 라운드마다 적이 등장합니다.
// 남은 병사 중 등장한 적만큼 소모하여 적을 막을 수 있습니다.
// - 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임 종료
// 게임에는 무적권 이라는 스킬이있고, 무적권을 사용하면 병사소모없이 한 라운드 공격 막기 가능
// 무적권은 최대 k 번 사용가능, 최대한 많은 라운드를 진행한다.
//
// dfs, 빼거나 안빼거나 , k 사용횟수가 가 다 없어졋을때 혹은, 아예 끝나버릴때, 그때의 depth
// **/
//import java.util.*;
//class Solution {
//    public int solution(int n, int k, int[] enemy) { // 7 3 {4,2,4,5,3,3,1}
//        int answer = 0;
//        if(enemy.length <= k){
//            return enemy.length;
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        for(int e : enemy){
//            queue.add(e);
//            n -= e;
//            if(n < 0){
//                if(k == 0){
//                    return answer;
//                }
//                n = n + queue.poll();
//                k--;
//            }
//            answer++;
//        }
//
//        return answer;
//    }
//}
//
//// class Solution {
////     public int len;
////     public int K;
////     public int[] Enemy;
////     public int answer = 0;
//
////     public int solution(int n, int k, int[] enemy) {
////         len = enemy.length;
////         Enemy = enemy;
////         K = k;
//
////         if(len <= k){
////             return enemy.length;
////         }
//
////         dfs(n, 0, 0, "");
//
////         return answer;
////     }
//
////     public void dfs(int n, int depth, int idx, String str){
////         // 종료 조건
////         if(n <= 0 || depth == K){
////             if(n <= 0){
////                 idx--;
////             }
////             answer = Math.max(answer, idx);
////             return;
////         }
//
////         if(idx >= len){
////             return;
////         }
//
////         // 선택했을 때
////         dfs(n, depth + 1, idx+1,str+String.valueOf(idx));
//
////         // 선택하지 않았을 때
////         dfs(n - Enemy[idx], depth, idx + 1, str);
////     }
//// }