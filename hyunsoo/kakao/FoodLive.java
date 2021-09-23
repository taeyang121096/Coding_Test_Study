/**
 * 2019 KAKAO BLIND RECRUITMENT 무지의 먹방 라이브
 */
package kakao;
import java.util.*;
public class FoodLive {
class Solution {
    public int solution(int[] food_times, long k) {
        
        int answer = 0; 
        long sum=0;
        for(int i=0; i<food_times.length; i++){
            sum= sum + food_times[i];
        }
        if(sum<=k) return -1;
        
        int[][] food=new int[food_times.length][2];
        for(int i=0; i<food_times.length; i++){
            food[i][0]=i;
            food[i][1]=food_times[i];
        }
        
        Arrays.sort(food, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[1]==o2[1]) return o1[0]-o2[0];
               return o1[1]-o2[1];
           } 
        });
        
        int last=0;
        int index = food[0][1];
        int start = 0;
        
        for(int i=0; i<food.length; i++){
            if(food[i][1]==index) continue;
            
            long tmp = food.length-start;
            long step = index-last;
            long spend = (long) tmp * step;
            if(k>=spend){
                k-= spend;
                start=i;
                last=index;
                index=food[i][1];
            }else{
                break;       
            }            
        }

        int[][] tmpA= new int[food.length-start][2];
        for(int j=0; j<tmpA.length; j++){
            tmpA[j][0]=food[j+start][0];
            tmpA[j][1]=food[j+start][1];
        }
        Arrays.sort(tmpA, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
                }
        });                     
        
        k = k % (long)tmpA.length;
        
        answer=tmpA[(int)k][0];               
        return answer+1;
    }
}
}
