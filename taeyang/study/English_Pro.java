import java.util.*;
public class English_Pro {

    class Solution {
        //      1번 부터 ~ 끝까지
//      끝에서부터는 다시 1번부터
//     이전에 나온 단어 사용 못함
//     한글자 인정 x
//
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            List<String> list = new ArrayList<>();
            int idx =-1;
            for(int i = 0;i<words.length;i++){
                if(list.contains(words[i])){
                    idx = i;
                    break;
                }
                if(!list.isEmpty()){
                    String str1 = list.get(list.size()-1);
                    if(str1.charAt(str1.length()-1) != words[i].charAt(0)){
                        idx = i;
                        break;
                    }
                }
                list.add(words[i]);
            }


            if(idx != -1){
                answer[0] = idx%n+1;
                answer[1] = idx/n+1;
            }

            return answer;
        }
    }
}
