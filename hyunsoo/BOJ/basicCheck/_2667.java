package BOJ.basicCheck;
import java.io.*;
import java.util.*;
public class _2667 {

  static int N;
  static int[][] arr;
  static ArrayList<Integer> list = new ArrayList<>();
  static int[] dx={0,0,-1,1};
  static int[] dy={1,-1,0,0};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N= Integer.parseInt(br.readLine());
    arr= new int[N+1][N+1];

    for(int i=0; i<N; i++){
      String[] str = br.readLine().split("");
      for(int j=0; j<str.length; j++){
        arr[i][j]=Integer.parseInt(str[j]);
      }    
    }
    

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(arr[i][j]==1){
          int count = dfs(i,j);
          list.add(count);
        } 
      }
    }

    int[] answer= new int[list.size()];
    for(int i=0; i<list.size(); i++){
      answer[i]=list.get(i);
    }
    Arrays.sort(answer);
    
    StringBuilder sb = new StringBuilder();
    sb.append(answer.length+"\n");
    for(int i=0; i<answer.length; i++){
      sb.append(answer[i]+"\n");
    }
    System.out.println(sb.toString());

  }

  public static int dfs(int x, int y){

    int count =1;
    
    arr[x][y]=2;

    for(int i=0; i<4; i++){
      int X= x+dx[i];
      int Y= y+dy[i];

      if(X<0 || Y<0 || X>=arr.length || Y>=arr.length) continue;

      if(arr[X][Y]==1) count += dfs(X,Y);
    }


    return count;
  }


}
