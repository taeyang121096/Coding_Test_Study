package BOJ.nhnCommerce;
import java.io.*;
import java.util.*;

public class _pretest {
  
  static int[][] arr;
  static boolean[][] visit;
  static int size=0; 
  static int count=0;  
  static int n;
  static int[] dx={0,0,1,-1};
  static int[] dy={1,-1,0,0};
  static List<Integer> answer = new LinkedList<>();
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n= Integer.parseInt(br.readLine());
    arr= new int[n][n];
    for(int i=0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int j=0; j<n; j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    visit = new boolean[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(!visit[i][j] && arr[i][j]==1){
          visit[i][j]=true;
          count=0;
          size++;
          dfs(i,j);
          answer.add(count);
        }
      }
    }

    Collections.sort(answer);

    StringBuilder sb= new StringBuilder();
    sb.append(size+"\n");

    for(int i=0; i<answer.size(); i++){
      sb.append(answer.get(i)+" ");
    }
    sb.append("\n");

    System.out.println(sb.toString());
  }

  public static void dfs(int x, int y){
    count++;
    for(int i=0; i<4; i++){
      int tx = x+ dx[i];
      int ty = y+ dy[i];

      if( tx >= n || tx < 0 || ty >= n || ty < 0 ) continue;

      if(!visit[tx][ty] && arr[tx][ty]==1){
        visit[tx][ty]=true;
        dfs(tx,ty);
      }
    }
  }
}
