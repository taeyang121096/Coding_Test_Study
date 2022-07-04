// 현재 진행된 작업의 진도 : progresses
// 작업의 개발 속도 : speeds
// 배포되는 기능의 수를 return
// 배포는 하루의 한번, 하루의 작업을 완료한 후 배포

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int time = 0;
        int count = 0;
        double needs;
        
        for(int i = 0; i<progresses.length; i++){
            needs = Math.ceil((double)(100-progresses[i])/speeds[i]);
            queue.offer((int)needs);
        }
        while(!queue.isEmpty()){
            if(queue.peek()<=time){
                queue.poll();
                count++;
            }
            else{
                if(count>0){
                    list.add(count);
                    count = 0;
                }
                time++;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}