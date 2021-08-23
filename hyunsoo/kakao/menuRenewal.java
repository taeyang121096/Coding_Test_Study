/**
 * 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼
 */

package kakao;
import java.util.*;

public class menuRenewal {
class Solution {
   
    HashMap<String,Integer> map;
    StringBuilder sb;
    
    public void combin(String str, int index, int cnt, int course_length){
        if(cnt==course_length){
            if(!map.containsKey(sb.toString())) map.put(sb.toString(), 1);
            else map.put(sb.toString(),map.get(sb.toString())+1);
        }
               
        for(int i=index; i<str.length(); i++){
            sb.append(str.charAt(i));
            combin(str,i+1,cnt+1,course_length);
            sb.delete(cnt,cnt+1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<orders.length; i++){
            char[] str = orders[i].toCharArray();
            Arrays.sort(str);
            orders[i] =new String(str);
        }
        
        for(int i=0; i<course.length; i++){
            map=new HashMap<>();
            
            for(int j=0; j<orders.length; j++){
                sb= new StringBuilder();
                if(course[i]<=orders[j].length()){
                    combin(orders[j],0,0,course[i]);
                }
            }
            int max = Integer.MIN_VALUE;
            
            Collection<Integer> values = map.values();
            for(Integer value : values){
                max=Math.max(max,value);
            }
            
            if(max>=2){
                Set<String> keys = map.keySet();
                for(String key : keys){
                    if(map.get(key)==max) answer.add(key);
                }       
            }
        }
        
        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        for(int i=0; i<ans.length; i++){
            ans[i]=answer.get(i);
        }
        return ans;
    }
}
}
