import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = k;
        List<Integer> list = new ArrayList<>();
        
        if(enemy.length <= k){
            return enemy.length;
        }
        
        for(int i = 0; i < k; i++){
            list.add(enemy[i]);
        }
        
        Collections.sort(list);
        for(int i = k; i < enemy.length; i++){
            if(enemy[i] <= list.get(0)){
                if(n < enemy[i]){
                    break;
                }
                n -= enemy[i];
                answer++;
            }
            else{
                if(n < list.get(0)){
                    break;
                }
                n -= list.remove(0);
                int pos = binary(enemy[i], list);
                list.add(pos, enemy[i]);
                answer++;
            }
        }
        return answer;
    }
    public int binary(int key, List<Integer> list){
        int left = 0;
        int right = list.size() - 1;
        int mid;
        
        while(left <= right){
            mid = (left + right) / 2;
            if(list.get(mid) < key){
                left = mid + 1;
            }
            else if(list.get(mid) > key){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return right + 1;
    }
}