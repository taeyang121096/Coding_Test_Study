//import java.util.*;
//class Solution {
//    public int[] solution(String msg) {
//        ArrayList<Integer> list = new ArrayList<>();
//        HashMap<String, Integer> map = new HashMap<>();
//        char ch = 'A';
//        for(int i = 1 ; i < 27 ; ++i){
//            map.put(ch + "", i);
//            ch += 1;
//        }
//
//        int start = 27;
//        boolean flag = false;
//        for(int i = 0; i < msg.length(); i++){
//            String word = msg.charAt(i) + ""; //
//
//            while(map.containsKey(word)){ // K
//                i++;
//                if(i == msg.length()){
//                    flag = true;
//                    break;
//                }
//                word += msg.charAt(i); // KA
//            }
//
//            if(flag){
//                list.add(map.get(word)); // KA
//                break;
//            }
//
//            // list에 넣을 것은 K
//            list.add(map.get(word.substring(0,word.length()-1)));
//            map.put(word, start++);
//            i--;
//        }
//
//        int[] answer = new int[list.size()];
//        for(int i = 0; i<list.size();i++){
//            answer[i] = list.get(i);
//        }
//        return answer;
//    }
//}