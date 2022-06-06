import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> ans = new ArrayList<>();
//         초기화
        List<String> method = new ArrayList<>();
        List<String> id = new ArrayList<>();
        Map<String,String> nickname = new HashMap<>();
//         입력 순서대로 넣어 주기
        for(String str : record){
            String[]tmp = str.split(" ");
            if(tmp[0].equals("Leave")){
                method.add(tmp[0]);
                id.add(tmp[1]);
            }else{
                method.add(tmp[0]);
                id.add(tmp[1]);
                nickname.put(tmp[1],tmp[2]);
            }
        }
        StringBuilder sb = new StringBuilder();
//         출력 부분
        for(int i = 0;i<method.size();i++){
            sb.setLength(0);
            if(method.get(i).equals("Enter")){
                sb.append(nickname.get(id.get(i)));
                sb.append("님이 들어왔습니다.");
            }else if(method.get(i).equals("Leave")){
                sb.append(nickname.get(id.get(i)));
                sb.append("님이 나갔습니다.");
            }
            if(sb.length() != 0)
                ans.add(sb.toString());
        }


        return ans.toArray(new String[0]);
    }
}