///**
// 앞 단어의 마지막 단어와 같아야 하며, 같은 단어가 나오는 순간 끝
// return [가장먼저 탈락하는 사람의 번호, 자신의 몇번째 차례에 탈락하는지]
// **/
//import java.util.*;
//class Solution {
//    public int[] solution(int n, String[] words) {
//        int[] answer = new int[2];
//        Map<String, Integer> map = new HashMap<>();
//
//        // map : {hello, 1} {one, 1} {even, 1} {never, 1}
//        // c   : r
//        char c = ' ';
//        for(int i = 0; i < words.length; i++){ // 4
//            String str = words[i]; // now
//
//            if(i == 0){
//                map.put(str, 1);
//                c = str.charAt(str.length() - 1); // k
//            } else {
//                if(c != str.charAt(0)){ //만약 c와 str 앞글자가 다르다면
//                    answer[0] = (i % n) + 1;
//                    answer[1] = (i / n) + 1;
//                    break;
//                } else { // 같다면
//                    if(!map.containsKey(str)){
//                        map.put(str, 1);
//                        c = str.charAt(str.length() - 1); // k
//                    } else {
//                        answer[0] = (i % n) + 1;
//                        answer[1] = (i / n) + 1;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return answer;
//    }
//}