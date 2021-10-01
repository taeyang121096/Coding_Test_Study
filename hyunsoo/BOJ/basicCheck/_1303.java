package BOJ.basicCheck;
import java.io.*;
public class _1303 {
  
  static int N,M;
  static String[][] arr;
  static boolean[][] visit;
  static int count;

  static int[] dx={0,0,1,-1};
  static int[] dy={1,-1,0,0};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    arr= new String[M][N];
    visit=new boolean[M][N];

    for(int i=0; i<M; i++){
      String[] s = br.readLine().split("");
      for(int j=0; j<N; j++){
        arr[i][j]= s[j];
      }
    }
    
    int W=0;
    int B=0;
    for(int i=0; i<M; i++){
      for(int j=0; j<N; j++){
        if(!visit[i][j]){
          visit[i][j]=true;
          count=0;
          if(arr[i][j].equals("W")){
            dfs("W",i,j);
            W+=(count*count);
          }else{
            dfs("B",i,j);
            B+=(count*count);
          }
        }
      }
    }
    System.out.print(W+" "+B);
  }
  public static void dfs(String str, int a, int b){
    count++;

    for(int i=0; i<4; i++){
      int x=a+dx[i];
      int y=b+dy[i];

      if(x<0 || y<0|| x>=M || y>=N) continue;

      if(!visit[x][y] && arr[x][y].equals(str)){
        visit[x][y]=true;
        dfs(str,x,y);
      }
    }
  }
}
