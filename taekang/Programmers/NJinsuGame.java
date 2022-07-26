//import java.util.*;
//class Solution {
//    public String solution(int n, int t, int m, int p) {
//        // 1. 숫자를 0부터 시작해서 차례대로,, 첫 0 둘 1...열 9
//        // 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번쨰 사람은 10의 첫 자리인 1,
//        StringBuilder sb = new StringBuilder();
//
//        // 10진법, 만약
//        // 1, 2, 3, 4, 5, 6, 7, 8, ... (숫자, 진수)
//        // String num = Integer.toString(i, n); //
//        for(int i = 0; i < t*m; i++){
//            // String num = Integer.toString(i, n);
//            // answer+= num;
//            sb.append(Integer.toString(i, n));
//        }
//        StringBuilder ans = new StringBuilder();
//
//        for(int i = 0; i < t*m; i++){
//            if(i%m==p-1){
//                // ans+=answer.charAt(i);
//                ans.append(sb.charAt(i));
//            }
//        }
//        return ans.toString().toUpperCase();
//    }
//}