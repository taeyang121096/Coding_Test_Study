/**
 * 2019 KAKAO BLIND RECRUITMENT 실패율
 */
package kakao;
import java.util.*;
public class failRate {
class Solution {
    class stage{
        int success;
        int fail;
        public stage(int success, int fail){
            this.success=success;
            this.fail=fail;
        }     
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        stage[] st = new stage[N+2];
        for(int i=0; i<N+2; i++){
            st[i]=new stage(0,0);
        }
        
        for(int s : stages){
            for(int i=1; i<=s; i++){
                st[i].success++;
                if(i==s && s != N+1) st[i].fail++; 
            }
        }
        
        double[][] ans = new double[N][2];
               
         for(int i=1; i<N+1; i++){
             if(st[i].success!=0)
                ans[i-1][0]= (double)st[i].fail/st[i].success;
              else ans[i-1][0]=0;
             ans[i-1][1]=i;
         }
        
        Arrays.sort(ans,new Comparator<double[]>(){
            public int compare(double[] o1, double[] o2){
                if(o1[0]==o2[0]){
                    if(o1[1]>o2[1]) return 1;
                    else return -1;
                }
                if(o1[0]>o2[0]) return -1;
                else return 1;
            }
        });
        
        for(int i=0; i<N; i++){
            answer[i]=(int)ans[i][1];
        }
               
        return answer;
    }
}
}
