package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _13023 {
  
  static boolean[] visit;
  static List<Integer>[] list;
  static int N, answer=0;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N];
    for(int i=0; i<N; i++){
      list[i] = new ArrayList<>();
    }

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine()," ");
      int x  = Integer.parseInt(st.nextToken());
      int y  = Integer.parseInt(st.nextToken());
      list[x].add(y);
      list[y].add(x);
    }

    for(int i=0; i<N; i++){
      visit = new boolean[N];
      visit[i]=true;
      dfs(i,1);
      visit[i]=false;
    }

    System.out.print(answer);
  }

  public static void dfs(int index,int dept){
    if(answer==1){
      return;
    }
    if(dept==5){
      answer=1;
      return;
    }


    for(int i : list[index]){
      if(!visit[i]){
        visit[i]=true;
        dfs(i,dept+1);
        visit[i]=false;
      }
    }
    // 시간초과 발생
    // for(int i=0; i<N; i++){
    //   if(list[index].contains(i) && !visit[i]){
    //     visit[i]=true;
    //     dfs(i,dept+1);
    //     visit[i]=false;
    //   }
    // }

  }
}
