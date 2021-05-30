import java.util.*;

class programers_bridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i<bridge_length; i++){
            queue.offer(0);
        }
        
        int i=0;
        
        while(bridge_weight!=0||i<truck_weights.length){
            bridge_weight -= queue.poll();
            
            if(i>=truck_weights.length){
                queue.add(0);
                answer++;
            }
            else if(bridge_weight+truck_weights[i]<=weight){
                queue.offer(truck_weights[i]);
                bridge_weight += truck_weights[i];
                i++;
                answer++;
            }
            else{
                queue.add(0);
                answer++;
            }
        }
        return answer;
    }
}
