import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        Map<Integer, ArrayList<Integer>>hm = new HashMap<>();
        
        for(int i = 0; i<a.length; i++){
            if(hm.containsKey(a[i])){
                ArrayList<Integer> al = new ArrayList<>();
                al = hm.get(a[i]);
                al.add(i);
                hm.put(a[i], al);
            }
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                hm.put(a[i], al);
            }
        }
        
        for(int key : hm.keySet()){
            ArrayList<Integer> al = new ArrayList<>();
            al = hm.get(key);
            if(al.size() * 2 < answer || al.size()<=1){
                continue;
            }
            int last = -1;
            int cnt = 0;
            for(int i = 0; i<al.size(); i++){
                int tmp = al.get(i);
                if(tmp > 0 && a[tmp-1] != a[tmp] && tmp-1 > last){
                    cnt+=2;
                }
                else if(tmp<a.length-1 && a[tmp+1] != a[tmp]){
                    cnt+=2;
                    last = tmp+1;
                }
            }
            if(cnt>2){
                answer = Math.max(answer, cnt);
            }
        }
        return answer;
    }
}