import java.util.*;
class Solution {

    static List<String[]> list = new ArrayList<>();
    static Map<String, String> id =  new HashMap<>();

    public String[] solution(String[] record) {

        for(String s : record){
            if(s.split(" ")[0].equals("Enter")){
                id.put(s.split(" ")[1], s.split(" ")[2]);

                String[] tmp = new String[2];
                tmp[0] = "Enter";
                tmp[1] = s.split(" ")[1];

                list.add(tmp);
            }
            else if(s.split(" ")[0].equals("Leave")){
                String[] tmp = new String[2];
                tmp[0] = "Leave";
                tmp[1] = s.split(" ")[1];
                list.add(tmp);
            }
            else{
                id.put(s.split(" ")[1], s.split(" ")[2]);
            }

        }

        String[] answer = new String[list.size()];
        int count =0;
        for(String[] s : list){
            String cmd = s[0];
            String user = s[1];

            StringBuffer sb = new StringBuffer();
            sb.append(id.get(user)+"님이 ");
            if(cmd.equals("Enter")){
                sb.append("들어왔습니다.");
            }else{
                sb.append("나갔습니다.");
            }
            answer[count++] = sb.toString();
        }

        return answer;
    }
}