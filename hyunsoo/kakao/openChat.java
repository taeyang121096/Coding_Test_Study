/**
 * 2019 KAKAO BLIND RECRUITMENT 오픈채팅방
 */
package kakao;
import java.util.*;
public class openChat {
class Solution {
    
    class records{
        String uid;
        String order;
        public records(String uid,String order){
            this.uid=uid;
            this.order=order;
        }
    }
   
    Map<String,String> userid = new HashMap<>();  // userid 랑 닉네임 저장
    Queue<records> order = new LinkedList<>();  // uid랑 명령어(입장,퇴장) 저장
    
    public String[] solution(String[] record) {
        
        
        for(String r : record){
            String[] str = r.split(" ");
            
            if(str[0].equals("Change")){
                userid.replace(str[1], str[2]);
            }
            if(str[0].equals("Enter")){
                if(userid.containsKey(str[1])) userid.replace(str[1],str[2]);
                else userid.put(str[1],str[2]);
                order.add(new records(str[1],str[0]));
            }
            if(str[0].equals("Leave")){
                order.add(new records(str[1],str[0]));
            }
        }
        
        String[] answer = new String[order.size()];
        int size= order.size();
        
        for(int i=0; i<size; i++){
            records tmp= order.poll();
            String uid= tmp.uid;
            String order= tmp.order;
            
            answer[i] = userid.get(uid)+"님이";
            
            if(order.equals("Enter")){
                answer[i]+=" 들어왔습니다.";
            }else{
                answer[i]+=" 나갔습니다.";
            }
            
        } 
        return answer;
    }
}
}
