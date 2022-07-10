import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        HashMap <String, List<String>> hm = new HashMap<>();
        List<String> list;
        StringTokenizer st;
        String userId;
        String reportId;
        
        for(int i = 0; i<report.length; i++){
            st = new StringTokenizer(report[i]);
            userId = st.nextToken();
            reportId = st.nextToken();
            if(hm.containsKey(reportId)){
                list = hm.get(reportId);
                if(!list.contains(userId)){
                    list.add(userId);
                    hm.put(reportId, list);
                }
            }
            else{
                list = new ArrayList<>();
                list.add(userId);
                hm.put(reportId, list);
            }
        }
        int index = 0;
        for(String str:hm.keySet()){
            if(hm.get(str).size()>=k){
                for(String str2:hm.get(str)){
                    for(int i = 0; i<id_list.length;i++){
                        if(str2.equals(id_list[i])){
                            answer[i]++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}