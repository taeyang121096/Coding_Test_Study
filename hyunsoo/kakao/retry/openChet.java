package hyunsoo.kakao.retry;
import java.util.*;
class Solution {
    
    Map<String,String> userid = new HashMap<>();
    Queue<action> act = new LinkedList<>();
    
    class action{
        String userid;
        String action;
        public action(String userid, String action){
            this.userid=userid;
            this.action=action;
        }
    }
    
    public String[] solution(String[] record) {
        
        
        for(String rec : record){
            String[] tmp = rec.split(" ");
            if(tmp[0].equals("Enter")){
                act.add(new action(tmp[1],tmp[0]));
                userid.put(tmp[1],tmp[2]);

            }else if(tmp[0].equals("Leave")){
                act.add(new action(tmp[1],tmp[0]));                
            }else{
                userid.put(tmp[1],tmp[2]);
            }
        }
        
        String[] answer = new String[act.size()];
        int size = act.size();
        for(int i=0; i<size; i++){
            action tmp = act.poll();
            String name = userid.get(tmp.userid);
            
            answer[i] = (name+"님이 ");
            
            if(tmp.action.equals("Enter")){
                answer[i] += "들어왔습니다.";
            }else{
                answer[i] += "나갔습니다.";
            }
            
        }
        
        return answer;
    }
}