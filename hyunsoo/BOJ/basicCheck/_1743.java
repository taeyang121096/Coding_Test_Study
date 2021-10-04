package BOJ.basicCheck;
import java.util.*;
public class _1743 {
  static int[][] arr;
  static boolean[][] visit;
  static int[] dx={1,-1,0,0};
  static int[] dy={0,0,1,-1};
  static int N,M;

  static class node{
    int x;
    int y;
    public node(int x, int y){
      this.x=x;
      this.y=y; 
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String[] input= sc.nextLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    int K = Integer.parseInt(input[2]);

    arr = new int[N+1][M+1];
    visit= new boolean[N+1][M+1];
    for(int i=0; i<K; i++){
      String[] tmp= sc.nextLine().split(" ");
      int a= Integer.parseInt(tmp[0]);
      int b= Integer.parseInt(tmp[1]);
      arr[a][b]=1;
    }

    int answer=0;

    for(int i=1; i<=N; i++){
      for(int j=1; j<=M; j++){
        if(!visit[i][j] && arr[i][j]==1){
          visit[i][j]=true;
          answer= Math.max(find(i,j),answer);
        }
      }
    }

    System.out.println(answer);
  }
  
  public static int find(int x, int y){
    
    int answer =0;
    Queue<node> q = new LinkedList<>();
    q.add(new node(x,y));

    while(!q.isEmpty()){
      node tmp = q.poll();
      answer++;

     for(int i=0; i<4; i++){
      int X=tmp.x+dx[i];
      int Y=tmp.y+dy[i];

      if(X<=0 || X>N || Y<=0 || Y>M ) continue;

      if(arr[X][Y]==1 && !visit[X][Y]){
        visit[X][Y]=true;
        q.add(new node(X,Y));
      }
     }

    }   
    return answer;
  }


}
