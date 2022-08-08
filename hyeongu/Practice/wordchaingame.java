// 탈락한 사람과 자신의 몇번째 차례에 탈락하는지 return
// 2<=사람의 수 <=10  2<=단어의길이<=50
// words<=100

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String>hs = new HashSet<>();
        int[] answer = {0, 0};
        
        hs.add(words[0]);
        
        for(int i = 1; i<words.length; i++){
            if(!hs.contains(words[i])){
                if(words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0)){
                    hs.add(words[i]);
                    continue;
                }
            }
            answer[0] = (i%n) + 1;
            answer[1] = (i/n) + 1;
            break;
        }    
        return answer;
    }
}