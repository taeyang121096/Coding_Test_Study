package Programmers;

import java.util.*;

public class NearestLetter_Prog {
	public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                answer[i] = -1;
                hm.put(ch, i);
            } else {
                answer[i] = i - hm.get(ch);
                hm.put(ch, i);
            }
        }
        return answer;
    }
}
