package kakao;
import java.util.*;

public class jewel_shopping {
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        
        for(int i=0; i<gems.length; i++){
            hs.add(gems[i]);
        }
        int size= hs.size();

        HashSet<String> gem = new HashSet<>();
        HashMap<String,Integer> gemCount = new HashMap<>();
              
        int left=0, right=0;
        int start=0;
        int leng=Integer.MAX_VALUE;
        
        while(right<gems.length){
            
            gem.add(gems[right]);
            if(gemCount.containsKey(gems[right]))
                gemCount.put(gems[right],gemCount.get(gems[right])+1);
            
            else gemCount.put(gems[right],1);
            
            if(gem.size()==size){
                while(gemCount.get(gems[left])>1){
                    gemCount.put(gems[left],gemCount.get(gems[left])-1); 
                    left++;                
                }
                if(leng>(right-left+1)){
                    start=left;
                    leng=right-left+1;
                }
                
                gemCount.put(gems[left],gemCount.get(gems[left])-1);
                gem.remove(gems[left]);
                left++;   
            }  
          
            right++;            
        }
        
        answer[0]=start+1;
        answer[1]=start+leng;
        
        return answer;
    }
}
}
