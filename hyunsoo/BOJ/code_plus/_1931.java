package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _1931 {
  
  static class node{
    int start;
    int end;
    public node(int start, int end){
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<node> list = new ArrayList<>();
    
    for(int i=0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      list.add(new node(s,e));
    }

    Collections.sort(list, new Comparator<node>(){
      public int compare(node o1, node o2){
        if(o1.end == o2.end){
          return o1.start - o2.start;
        }
        return o1.end-o2.end;
      }
    });

    int time=0;
    int answer=0;
    for(node n : list){
      if(time<=n.start){
        answer++;
        time= n.end;
      }
    }

    System.out.print(answer);

  }
}
