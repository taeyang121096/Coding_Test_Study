package BOJ.nhnCommerce;
import java.util.*;
import java.io.*;
public class _14719 {

  static int H,W;
  static int[] arr;
  static int answer=0;
  static int[] dy={1,-1};
  static boolean[] visit; 

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    H=Integer.parseInt(st.nextToken());
    W=Integer.parseInt(st.nextToken());

    arr=new int[W];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<W; i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }


    for(int i=0; i<H; i++){
      visit = new boolean[W]; 
      for(int j=1; j<W-1; j++){
        if(arr[j]<=i && !visit[j]){
          find(i,j);
        }
      }
    }
    System.out.println(answer);
  }
  public static void find(int x, int y){
    Queue<Integer> q = new LinkedList<>();
 
    q.add(y);
    int count=0;
    boolean check=false;
    while(!q.isEmpty()){
      int tmp=q.poll();
      visit[tmp]=true;

      count++;
      for(int i=0; i<2; i++){
        int ty= tmp + dy[i];
        
        if(ty==0 && arr[ty]<=x){ check= true;}
        if(ty==W-1 && arr[ty]<=x) { check= true;}
        if(ty<0 || ty>=W) continue;

        if(!visit[ty] && arr[ty]<=x){
          visit[ty]=true;
          q.add(ty);
        }
      }
    }
    
    if(!check){ 
      answer += count;
    }
  }
}
