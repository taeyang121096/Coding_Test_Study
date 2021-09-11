import java.util.*;
public class 징검다리_binary_Search {
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int left=1;
        int right= distance;
        Arrays.sort(rocks);
        
        while(left<=right){
            int mid = (left+right)/2;
            int start=0;
            int remove=0;
            
            for(int i=0; i<rocks.length; i++){
                if(rocks[i]-start<mid) remove++;
                else{
                    start=rocks[i];
                }
            }
            if(distance-start <mid ) remove++;
            
            if(remove<=n){
                
                answer = mid>answer? mid: answer;
                left=mid+1;
            }else{
                right=mid-1;
            }        
        }
        
        return answer;
    }
}
  
}
