package hyunsoo.kakao.retry;
import java.util.*;
public class failRate {
class Solution {
    
    int[][] Stages;
    
    public int[] solution(int N, int[] stages) {
       
        
        Stages= new int[N+2][2];
        
        for(int i=0; i<stages.length; i++){
            int tmp = stages[i];
            for(int j=1; j<=tmp; j++){
                Stages[j][0]++;
            }
            Stages[tmp][1]++;
        }
        
        double[][] ans = new double[N][2];
        
        for(int i=1; i<=N; i++){
            
            ans[i-1][0]=i;
            if(Stages[i][0]==0) ans[i-1][1]=0;
            else ans[i-1][1]=(double)Stages[i][1]/Stages[i][0];
        }
        
 
        
        Arrays.sort(ans, new Comparator<double[]>(){
            public int compare(double[] o1, double[] o2){
                if(o1[1]==o2[1]){
                    if(o1[0]>o2[0]) return 1;
                    else if(o1[0]<o2[0]) return -1;
                    
                    return 0;
                }
                    if(o1[1]>o2[1]) return -1;
                    else if(o1[1]<o2[1]) return 1;
                    return 0;
            }
        });
               
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i]=(int)ans[i][0];
        }
        
        return answer;
    }
}
}
