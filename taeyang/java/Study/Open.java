import java.util.*;
class Solution {
    Queue<String[]> q = new LinkedList<>();
    Map<String,String> map = new HashMap<>();
    public String[] solution(String[] record) {

        for(String s : record){
            String[] cmd = s.split(" ");
            if(cmd[0].equals("Enter")){
                q.offer(new String[] {cmd[0],cmd[1]});
                map.put(cmd[1],cmd[2]);
            }
            else if(cmd[0].equals("Leave")){
                q.offer(new String[] {cmd[0],cmd[1]});
            }
            else{
                map.put(cmd[1],cmd[2]);
            }
        }
        String[] answer = new String[q.size()];
        int count = 0;
        for(String [] first : q){
            StringBuffer sb = new StringBuffer();
            sb.append(map.get(first[1])+"님이 ");
            if(first[0].equals("Enter"))
                sb.append("들어왔습니다.");
            else
                sb.append("나갔습니다.");
            answer[count++] = sb.toString();
        }



        return answer;
    }
}