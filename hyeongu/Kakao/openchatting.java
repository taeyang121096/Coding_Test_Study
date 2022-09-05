import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        Queue<String[]> q = new LinkedList<>();
        int cnt = 0;
        
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);
            String command = st.nextToken();
            String uid = st.nextToken();
            
            if(command.equals("Leave")){
                q.offer(new String[] {uid, command});
                cnt++;
            }
            else{
                String nick = st.nextToken();
                hm.put(uid, nick);
                if(command.equals("Enter")){
                    q.offer(new String[] {uid, command});
                    cnt++;
                }
            }
        }
        String[] answer = new String[cnt];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(!q.isEmpty()){
            String[] now = q.poll();
            String command = now[1];
            sb.append(hm.get(now[0]));
            if(now[1].equals("Enter")){
                sb.append("님이 들어왔습니다.");
            }
            else{
                sb.append("님이 나갔습니다.");
            }
            answer[i++] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}