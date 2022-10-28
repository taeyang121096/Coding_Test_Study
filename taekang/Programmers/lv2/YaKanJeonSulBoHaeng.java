///**
// 일정한 속도 1m/s, 경비병 - 감시 구간 안 겹침 & 일정 시간 휴식을 취함
// **/
//import java.util.*;
//class Solution {
//    public boolean isWork(int num, int diff, int start){
//        int n = num % diff; // 3
//        if(n == 0 || n > start){
//            return false;
//        }
//        return true;
//    }
//
//    public int solution(int distance, int[][] scope, int[][] times) {
//        boolean[] dis = new boolean[distance+1];
//        for(int j = 0; j < scope.length; j++){
//            int a = scope[j][0]; // 7
//            int b = scope[j][1]; // 8
//
//            int start = times[j][0]; // 2
//            int end = times[j][1]; // 2
//
//            int scope_start = -1;
//            int scope_end = -1;
//            if(a<b){
//                scope_start = a;
//                scope_end = b;
//            }  else {
//                scope_start = b;
//                scope_end = a;
//            }
//            // 근무 등차수열 : 등차 start+end,
//            // 휴식 등차수열 : 등차 start+end,
//            int diff = start + end; // 2 + 2 = 4
//
//            for(int i = scope_start; i <= scope_end; i++){
//                if(isWork(i, diff, start)){
//                    dis[i] = true;
//                }
//            }
//        }
//
//        // for(int i = 1; i < dis.length ; i++){
//        //     System.out.print(dis[i] + " ");
//        // }
//
//        int max = Integer.MIN_VALUE;
//        int len = 0;
//        for(int i = 1; i < dis.length; i++){
//            if(!dis[i]){
//                len++;
//            } else {
//                len++;
//                break;
//            }
//        }
//        max = Math.max(max, len);
//
//
//        return max;
//    }
//}