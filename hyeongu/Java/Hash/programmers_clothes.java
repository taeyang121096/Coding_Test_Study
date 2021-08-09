import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer>result = new HashMap<>();
        // hash에 옷의 종류와 갯수를 저장
        for(int i = 0; i<clothes.length;i++){
            result.put(clothes[i][1], result.getOrDefault(clothes[i][1], 0) + 1);
        }
        // 옷의 종류별로 갯수 + 1을 곱하면 전체 경우의수	
        for (String key : result.keySet()) {
            answer *= result.get(key) + 1;
        }
        // 옷을 하나도 안입는 경우 제외
        answer -= 1;
        return answer;
    }
}