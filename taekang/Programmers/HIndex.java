///**
// 논문 n 편 중, h 번 이상 인용된 논문이 h 편 이상, 나머지 논문이 h 번 이하 인용?
// h 이 최댓값이
// **/
//import java.util.*;
//class Solution {
//    public int solution(int[] citations) {
//        int answer = 0;
//        int arr_max = Integer.MIN_VALUE;
//        int max = Integer.MIN_VALUE;
//        Integer[] arr = new Integer[citations.length];
//        for(int i = 0; i < citations.length; i++){
//            arr[i] = citations[i];
//            arr_max = Math.max(arr_max, citations[i]);
//        }
//
//        Arrays.sort(arr, Collections.reverseOrder());
//
//
//        // 6 5 3 1 0
//        int h = 0;
//        while(h <= arr_max){
//            int cnt = 0;
//            for(int i = 0; i < arr.length; i++){
//                if(h <= arr[i]){
//                    cnt++;
//                }
//            }
//            int low_cnt = arr.length - cnt;
//
//            if(h <= cnt && h >= low_cnt){
//                max = Math.max(max, h);
//            }
//            h++;
//        }
//        return max;
//    }
//
//
//}
