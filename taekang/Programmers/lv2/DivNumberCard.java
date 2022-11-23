///**
// 철수
// 영희
// 절반씩 나눠서 가진 후, 가장 큰 양의 정수 a 의 값을 구하려고 함
//
// **/
//import java.util.*;
//class Solution {
//    public int solution(int[] arrayA, int[] arrayB) {
//        int answer = 0;
//
//        int min_a = Arrays.stream(arrayA).min().getAsInt(); // 배열 A 최솟값
//        int min_b = Arrays.stream(arrayB).min().getAsInt(); // 배열 B 최댓값
//
//
//        for(int i = 2; i <= min_a; i++){
//            boolean flag = false;
//            for(int j = 0; j < arrayA.length; j++){
//                if(arrayA[j]%i != 0){
//                    flag =true;
//                    break;
//                }
//            }
//            if(!flag){
//                int cnt = 0;
//                for(int j = 0; j < arrayB.length; j++){
//                    if(arrayB[j]%i != 0){
//                        cnt++;
//                    }
//                }
//                if(cnt==arrayB.length){
//                    answer = Math.max(answer, i);
//                }
//            }
//        }
//
//        for(int i = 2; i <= min_b; i++){
//            boolean flag = false;
//            for(int j = 0; j < arrayB.length; j++){
//                if(arrayB[j]%i != 0){
//                    flag =true;
//                    break;
//                }
//            }
//            if(!flag){
//                int cnt = 0;
//                for(int j = 0; j < arrayA.length; j++){
//                    if(arrayA[j]%i != 0){
//                        cnt++;
//                    }
//                }
//                if(cnt==arrayA.length){
//                    answer = Math.max(answer, i);
//                }
//            }
//        }
//
//        return answer;
//    }
//}