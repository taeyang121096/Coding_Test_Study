import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int tmp : tangerine){
            hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
        }

        Map<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for(int key : hm.keySet()){
            int tmp = hm.get(key);
            if(tmp >= k){
                answer = 1;
                break;
            }
            tm.put(tmp, tm.getOrDefault(tmp, 0) + 1);
        }
        
        for(int key : tm.keySet()){
            System.out.println(key + " " + tm.get(key));
        }
        
        for(int key : tm.keySet()){
            if(k <= 0){
                break;
            }
            if(tm.get(key)*key >= k){
                answer += (int)Math.ceil(k / (double)key);
                break;
            }
            else{
                answer += tm.get(key);
                k -= tm.get(key)*key;
            }
            
            // if(tm.get(key)*key == k){
            //     answer += tm.get(key);
            //     break;
            // } else if(tm.get(key)*key > k){
            //     if(k % 2 == 1){
            //         answer += k/key + 1;
            //         break;
            //     } else {
            //         answer += k/key;
            //         break;
            //     }
            // } else {
            //     answer += tm.get(key);
            //     k -= tm.get(key)*key;
            // }
        }
        
        return answer;
    }
}