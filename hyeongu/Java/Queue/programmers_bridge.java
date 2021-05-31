import java.util.*;

class programers_bridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;//다리 위의 트럭의 총 무게
        
        Queue<Integer> queue = new LinkedList<>();
        
        //다리의 길이만큼 큐를 0으로 채움
        for(int i = 0; i<bridge_length; i++){
            queue.offer(0);
        }
        
        int i=0;
        
        //다리에 트럭이 없고 모든 트럭이 지나갔을 경우 종료
        while(bridge_weight!=0||i<truck_weights.length){
            bridge_weight -= queue.poll();
            
            //더이상 지나갈 트럭이 없을 경우
            if(i>=truck_weights.length){
                queue.add(0);
                answer++;
            }
            //트럭이 추가로 지나갈 수 있는 경우
            else if(bridge_weight+truck_weights[i]<=weight){
                queue.offer(truck_weights[i]);
                bridge_weight += truck_weights[i];
                i++;
                answer++;
            }
            //트럭이 추가로 지날 수 없는 경우
            else{
                queue.add(0);
                answer++;
            }
        }
        return answer;
    }
}
