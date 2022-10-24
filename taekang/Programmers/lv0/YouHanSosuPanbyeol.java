///**
// 유한소수가 되기 위한 분수의 조건 : 붐노의 소인수가 2와5만 존재해야 한다
// 20 = 2*2*5
//
// 분자와 분모의 최대공약수로 약분 -> 기약분수
// 11 22
// 분자까지...int i = 1~11
// **/
//import java.util.*;
//class Solution {
//    public ArrayList<Integer> list = new ArrayList<>();
//    public int solution(int a, int b) {
//        int answer = 1;
//
//        int k = gcd(b,a);
//        // System.out.println(b/k);
//        div(b/k);
//
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i) != 2 && list.get(i) != 5){
//                return 2;
//            }
//        }
//
//        return answer;
//    }
//
//    public int gcd(int a, int b){
//        if(b==0) return a;
//        else return gcd(b, a % b);
//    }
//
//    public void div(int n){
//        if(n == 1){
//            return;
//        } else {
//            for(int i = 2; i <= n; i++){
//                if(n%i==0){
//                    list.add(i);
//                    div(n/i);
//                    break;
//                }
//            }
//        }
//    }
////}