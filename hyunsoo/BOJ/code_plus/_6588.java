package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _6588 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<Integer> hs = new HashSet<>();
    
  
    int[] dp= new int[500000];
    int point=0;
    
    for(int i=2; i<=1000000; i++){
      boolean check= false;
      for(int j=2; j*j<=i; j++){
        if(i%j==0){
          check=true;
          break;
        }
      }
      if(!check){
        dp[point++]=i;
        hs.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    int tmp;
   
    while((tmp= Integer.parseInt(br.readLine()))!=0){
      int max=0;
      int odd=0;
      for(int j=0; j<point; j++){
        if(dp[j]>tmp) break;
        
        int t = tmp - dp[j];
        if(hs.contains(t)) {
          max=t;
          odd= dp[j];
          break;
        }
      }
      if(max==0){
        sb.append("Goldbach's conjecture is wrong.\n");
      }else{
        sb.append(tmp+" = ").append(odd+" + ").append(max+"\n");
      }

    }
    System.out.println(sb.toString());
  }
}
