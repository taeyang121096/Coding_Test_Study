import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> result = new HashMap<>();
        // hash에 지원자이름을 추가하고 value에 1을 더함
        for(int i = 0; i<participant.length; i++){
            result.put(participant[i], result.getOrDefault(participant[i], 0) + 1);
        }
        // hash에서 완주자이름의 value에서 1을 뺌
        for(int i = 0; i<completion.length; i++){
            result.put(completion[i], result.get(completion[i])-1);
        }
        // value가 1인 사람이 완주하지 못한 사람
        for(String key : result.keySet()){
            if(result.get(key)==1) {
                return key;
            }
        }
        return null;
    }
}