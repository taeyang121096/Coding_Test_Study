package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _15686 {
  
  static int N,M;
  static int countChick=0;
  static int[][] arr;
  static int answer = Integer.MAX_VALUE;
  static List<node> list = new ArrayList<>();
  static boolean[] delete;
  static class node{
    int x;
    int y;
    public node(int x ,int y){
      this.x=x;
      this.y=y;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr= new int[N+1][N+1];

    for(int i=1; i<=N; i++){
      st = new StringTokenizer(br.readLine()," ");
      for(int j=1; j<=N; j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
        if(arr[i][j]==2) {
          countChick++;
          list.add(new node(i,j));
        }
      }
    }
    delete = new boolean[list.size()];

    deleteChick(0,0, countChick - M);

    System.out.print(answer);
  }
  
  public static void check(){
    int sumdir = 0;
    for(int i=1; i<=N; i++){
      for(int j=1; j<=N; j++){
        if(arr[i][j]==1){
          int dir=Integer.MAX_VALUE;
          for(int k=0; k<list.size(); k++){
            if(!delete[k]){
              node tmp = list.get(k);
              dir = Math.min(dir, Math.abs(i-tmp.x)+Math.abs(j-tmp.y));
            }
          }
          sumdir+=dir;
        }
      }
    }

    answer = Math.min(answer,sumdir);
  }

  public static void deleteChick(int select, int selectIndex ,int index){
    if(select == index){
      check();
      return;
    }

    for(int i=selectIndex; i<list.size(); i++){
      delete[i]=true;
      deleteChick(select+1, i+1 , index);
      delete[i]=false;
    }
  }
}
