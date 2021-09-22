package BOJ.Kruskal;
import java.util.*;
import java.io.*;
public class _1197 {

  static class node implements Comparable<node>{
    int A;
    int B;
    int W;
    public node(int A, int B, int W){
      this.A=A;
      this.B=B;
      this.W=W;
    }
    public int compareTo(node o){
      return this.W - o.W;
    }
  }
  static int[] parent;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int V= Integer.parseInt(st.nextToken());
    int E= Integer.parseInt(st.nextToken());
    
    PriorityQueue<node> q = new PriorityQueue<>();

    parent = new int[V+1];
    for(int i=1; i<=V; i++) parent[i]=i;
    
    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine()," ");
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      int w=Integer.parseInt(st.nextToken());
      q.add(new node(a,b,w));
    }

    int sum=0;

    while(!q.isEmpty()){
      node n = q.poll();

      int parentA=find(n.A);
      int parentB=find(n.B);
      if(parentA!=parentB){
        parent[parentA]=parentB;
        sum+=n.W;
      }
    }
    System.out.println(sum);

  }
  public static int find(int x){
    if(parent[x]==x) return x;
    else return parent[x] = find(parent[x]);
  }
}
