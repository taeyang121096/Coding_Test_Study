// 사전은 A ~ Z : 1 ~ 26으로 초기화
// 주어진 단어를 사전에 등록되어있는 인덱스로 출력
// 출력 후 사전에 등록되어있는 문자 + 다음문자를 새로 사전에 등록

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int count = 1;
        for(int i = 65; i<91; i++){
            String tmp = (char)i+"";
            hm.put(tmp, count++);
        }
        
        String tmp = msg;
        while(tmp.length()>0){
            int i;
            for(i = 1; i<tmp.length(); i++){
                if(!hm.containsKey(tmp.substring(0, i+1))){
                    al.add(hm.get(tmp.substring(0, i)));
                    hm.put(tmp.substring(0, i+1), count++);
                    break;
                }
            }
            if(i==tmp.length()){
                al.add(hm.get(tmp.substring(0, i)));
            }
            tmp = tmp.substring(i);
        }
        
        int[] answer = new int[al.size()];
        for(int j = 0; j < al.size(); j++){
            answer[j] = al.get(j);
        }
        return answer;
    }
}