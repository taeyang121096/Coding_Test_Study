//import java.util.*;
//class Solution {
//    public String solution(int[] numbers) {
//        String answer = "";
//        String[] arr = new String[numbers.length]; // 3
//
//        for(int i = 0; i < numbers.length; i++){
//            arr[i] = String.valueOf(numbers[i]);
//        }
//
//        Arrays.sort(arr, new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2){
//                return (o2+o1).compareTo(o1+o2);
//            }
//        });
//
//        if(arr[0].equals("0")) return "0";
//
//        for(int i = 0; i < arr.length; i++){
//            answer += arr[i];
//        }
//
//        return answer;
//    }
//
//}