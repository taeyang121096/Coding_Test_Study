//import java.util.*;
//
//class Solution {
//    static String s;
//    static int K;
//    static List<String> list = new ArrayList<>();
//
//    public String solution(String number, int k) {
//        // k 개의 수를 제거했을 때 얻을 수 있는 가장 큰 수
//        //
//        String answer = "";
//
//        // k 가 2면 number의 012 123 4 - 2 = 2개
//        // k 가 3이면 number의 0123 1234 2345 3456  7 - 3 = 4개
//        // k 가 4이면 number의 01234 12345 23456 34567 345678 456789 10 - 4 = 6개
//        StringBuilder sb = new StringBuilder();
//        int idx = 0;
//
//        for(int i = 0; i < number.length() - k; i++){ // 0 1
//            int max = -1;
//
//            for(int j = idx; j <= k+i; j++ ){ // 0 1 2 , 1 2 3
//                if(max < number.charAt(j) - '0'){
//                    max = number.charAt(j) - '0';
//                    idx = j + 1; // 2
//                }
//            }
//            sb.append(max);
//        }
//
//        return sb.toString();
//    }
//}