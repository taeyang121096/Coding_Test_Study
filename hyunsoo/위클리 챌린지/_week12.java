import java.util.*;
public class _week12 {
class Solution {
    int K;
    int[][] dan;
    boolean[] visit;
    List<Integer> list = new ArrayList<>();
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
       
        K=k;
        dan = dungeons;
        visit= new boolean[dan.length];
        
        for(int i=0; i<dan.length; i++){
            visit[i]=true;
            list.add(i);
            made(1);
            visit[i]=false;
            list.remove(list.size()-1);
        }
        
        return answer;
    }
    
    public void made(int index){
        
        if(index == dan.length){
            answer = Math.max(answer, clear());
            return;
        }
        
        for(int i=0; i<dan.length; i++){
            if(!visit[i]){
                visit[i]=true;
                list.add(i);
                made(index+1);
                visit[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    
    
    public int clear(){
        
        int count=0;
        int k = K;
       
        for(int i=0; i<list.size(); i++){
            int tmp = list.get(i);
            if(k >= dan[tmp][0]){
                k -= dan[tmp][1];
                count++;
                
            }else{
                return count;
            }
        }
        return count;
    }
}

}
