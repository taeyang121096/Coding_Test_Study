// 프로그래머스 위클리 챌린지 9주차
import java.util.*;
public class week9 {
class Solution {

    int[][] wire;
    boolean[] visit;
    int count=0;
    int a=0;
    int b=0;
    public int solution(int n, int[][] wires) {
        int answer = 100000000;
            
        for(int i=0; i<wires.length; i++){
            int tmpx = wires[i][0];
            int tmpy = wires[i][1];
            wires[i][0]=0;
            wires[i][1]=0;  
            wire=wires;
      
            visit=new boolean[n+1];
            a=0;
            b=0;
            count=0;
            for(int j=1; j<=n; j++){
                if(!visit[j]){
                    visit[j]=true;
                    bfs(j);
                    count++;
                }
            }
            System.out.println(Math.abs(a-b));
            answer=Math.min(answer,Math.abs(a-b));
           
            wires[i][0]=tmpx;
            wires[i][1]=tmpy;
        }
        
        return answer;
    }
    
    public void bfs(int x){
        
        Queue<Integer> q=new LinkedList<>();
        
        q.offer(x);
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(count==1) a++;
            else b++;
            
            for(int i=0; i<wire.length; i++){
                if(wire[i][0]==tmp && !visit[wire[i][1]]) {
                    visit[wire[i][1]]=true;
                    q.offer(wire[i][1]);
                }
                
                if(wire[i][1]==tmp && !visit[wire[i][0]]){
                    visit[wire[i][0]]=true;
                    q.offer(wire[i][0]);
                }   
            }
        }
    }
}
}
