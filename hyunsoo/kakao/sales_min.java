/**
 * 2021 KAKAO BLIND RECRUITMENT 매출 하락 최소화
 */
package kakao;
import java.util.*;
public class sales_min {
class Solution {
 
    int[] Sales;
    List<List<Integer>> children = new ArrayList<>();
    int[][] cost= new int[300000][2];
    
    void dp(int node){
        cost[node][0] = 0;
        cost[node][1] = Sales[node];
        if(children.get(node).isEmpty()) return;
        
        int excost=Integer.MAX_VALUE;
        for(int child : children.get(node)){
            dp(child);
            if(cost[child][0]<cost[child][1]){
                cost[node][0] += cost[child][0];
                cost[node][1] += cost[child][0];
                excost = Math.min(excost, cost[child][1]-cost[child][0]);
            }else{
                cost[node][0] += cost[child][1];
                cost[node][1] += cost[child][1];
                excost=0;
            }
        }
        cost[node][0] += excost;
    }
    
    public int solution(int[] sales, int[][] links) {
        
        Sales= sales;
        for(int i=0; i<sales.length; i++){
            children.add(new ArrayList<>());
        }
        
        for(int[] link : links){
            children.get(link[0]-1).add(link[1]-1);
        }
        
        dp(0);
        
        return Math.min(cost[0][0], cost[0][1]);
    }
}
}
