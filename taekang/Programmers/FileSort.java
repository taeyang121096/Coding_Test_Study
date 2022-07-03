//import java.util.*;
//
//class Solution {
//
//    static String[] divide(String str){
//        String head = "";
//        String num = "";
//        String tail = "";
//        int i = 0;
//        int j = 0;
//
//        // 머리
//        for(i = 0; i < str.length(); i++){
//            char c = str.charAt(i);
//            if(c >= '0' && c <= '9'){
//                break;
//            }
//            head += c;
//        }
//
//        // 숫자
//        for(j = i; j < str.length(); j++){
//            char c = str.charAt(j);
//            if(!(c >= '0' && c <= '9')){
//                break;
//            }
//            num += c;
//        }
//
//        // 꼬리
//        for(int k = j; k < str.length(); k++){
//            char c = str.charAt(k);
//            tail+=c;
//        }
//
//        String[] tmp = {head.toUpperCase(), num, tail};
//
//        return tmp;
//    }
//
//    public String[] solution(String[] files) {
//
//        Arrays.sort(files, new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2){
//                String[] str1 = divide(o1);
//                String[] str2 = divide(o2);
//
//                int head = str1[0].compareTo(str2[0]);
//
//                if(head == 0){
//                    int num1 = Integer.parseInt(str1[1]);
//                    int num2 = Integer.parseInt(str2[1]);
//                    return Integer.compare(num1, num2);
//                } else {
//                    return head;
//                }
//            }
//        });
//
//        return files;
//    }
//}