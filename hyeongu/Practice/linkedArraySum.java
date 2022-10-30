import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int size = elements.length;
        
        Set<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i : elements){
            q.offer(i);
        }
        for(int j = 0; j<size; j++){
            int tmp = 0;
            for(int i = 0; i<size; i++){
                tmp += q.peek();
                q.offer(q.poll());
            
                hs.add(tmp);
            }
            q.offer(q.poll());
        }
        return hs.size();
    }
}