package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _14889 {
  
  static int[][] arr;
  static int n;
  static int ans = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    arr= new int[n][n];
    for(int i=0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<n; j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
      }
    }
  
    make(0,"",0);
    System.out.print(ans);
  }

  public static void make(int index, String sum, int count){
  
    if(count==n/2) 
    {
      score(sum);
      return;
    }

    if(index==n) return;

    make(index+1, sum, count);
    make(index+1, sum+index+" ", count+1);
  }
  public static void score(String str){
    String[] tmp = str.split(" ");

    boolean[] check = new boolean[n];
    int[] team1= new int[n/2];
    int[] team2 = new int[n/2];

    for(int i=0; i<n/2; i++){
      team1[i]=Integer.parseInt(tmp[i]);
      check[Integer.parseInt(tmp[i])]=true;
    }
    
    int j=0;
    for(int i=0; i<n; i++){
      if(!check[i]){
        team2[j++]=i;
      }
    }

    int scoreT1=0;
    int scoreT2=0;

    for(int i=0; i<n/2; i++){
      for(int k=i; k<n/2; k++){
        scoreT1 = scoreT1 + arr[team1[i]][team1[k]] + arr[team1[k]][team1[i]];
        scoreT2 = scoreT2 + arr[team2[i]][team2[k]] + arr[team2[k]][team2[i]];
      }
    }

    ans = Math.min(ans, Math.abs(scoreT1 - scoreT2));
  }
}
