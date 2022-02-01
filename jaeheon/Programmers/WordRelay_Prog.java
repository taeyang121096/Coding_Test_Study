package Programmers;

import java.util.*;

class WordRealy_Prog {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int person = 1; // 사람 카운트
        int turn = 1; // 게임 카운트
        
        HashSet<String> hs = new HashSet<>();
        
        char lastIndex = words[0].charAt(0);
        
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            if(hs.contains(str) || str.charAt(0) != lastIndex){
                answer[0] = person;
                answer[1] = turn;
                break;
            }
            lastIndex = str.charAt(str.length() - 1);
            hs.add(str);
            person++;
            if(person > n){
                person = 1;
                turn++;
            }
        }
        
        return answer;
    }
}