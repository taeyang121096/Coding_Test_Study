package algorithmTest;

import java.util.*;
/* 순위 검색*/
class Solution {
    
    static int[] answer;
    static ArrayList<Integer> ans = new ArrayList<>();
    static Map<String,ArrayList<Integer>> map = new HashMap<>();
    
    public void caseBy(int level, String[] caseby, String str) {
        if(level == 4){
            if(map.containsKey(str)){
                map.get(str).add(Integer.parseInt(caseby[4]));
                return;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(caseby[4]));
            map.put(str,list);
            return;
        }
        caseBy(level+1,caseby,str+caseby[level]);
        caseBy(level+1,caseby,str+"-");
        
        
    }
    
    public void count(String str, int score){
        if(!map.containsKey(str)) return;
        List<Integer> list = map.get(str);
        int start = 0,end = list.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(list.get(mid) < score) start = mid +1;
            else end = mid -1;
        }
        ans.add(list.size() - start);
        
    }
    
    
    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        
        for(String x : info) caseBy(0,x.split(" "),"");    
        
        for(String key : map.keySet()) Collections.sort(map.get(key));
        for(String s : query) {
            String [] tmp = s.replace("and ","").split(" ");
            int score = Integer.parseInt(tmp[tmp.length -1]);
            tmp[tmp.length - 1]="";
            count(String.join("",tmp),score);
        }        
        
        for(int i=0;i<query.length;i++) answer[i] = ans.get(i);

        return answer;
    }
}