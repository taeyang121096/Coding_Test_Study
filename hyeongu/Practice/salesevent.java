import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> hm = new HashMap<>();
        int[] arr = new int[number.length];
        int cnt = 0;
        int len = 0;
        
        for(int i = 0; i< number.length; i++){
            hm.put(want[i], i);
            arr[i] = number[i];
            len += number[i];
        }
        
        for(int i = 0; i<discount.length; i++){
            if(i>=len){
                if(hm.containsKey(discount[i - len])){
                    int num = hm.get(discount[i - len]);
                    if(arr[num]>=0 && arr[num] < number[num]){
                        cnt--;
                        arr[num]++;
                    }
                    else if(arr[num]<0){
                        arr[num]++;
                    }
                }
            }
            
            if(hm.containsKey(discount[i])){
                int num = hm.get(discount[i]);
                arr[num]--;
                if(arr[num] >= 0){
                    cnt++;
                }
            }
            if(cnt == len){
                answer++;
            }
        }
        return answer;
    }
}