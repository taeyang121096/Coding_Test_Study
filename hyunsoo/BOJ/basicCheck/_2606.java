package BOJ.basicCheck;
import java.util.*;
public class _2606 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine());
    int k = Integer.parseInt(sc.nextLine());

    int[][] arr= new int[N+1][N+1];
    boolean[] visit= new boolean[N+1];
    
    for(int i=0; i<k; i++){
      String[] tmp = sc.nextLine().split(" ");
      int a = Integer.parseInt(tmp[0]);
      int b= Integer.parseInt(tmp[1]);
      arr[a][b]=1;
      arr[b][a]=1;
    }

    Queue<Integer> q= new LinkedList<>();
    q.add(1);
    visit[1]=true;
    int answer=0;
    while(!q.isEmpty()){
      int tmp = q.poll();
      answer++;

      for(int i=1; i<=N; i++){
        if(arr[tmp][i]==1 && !visit[i]){
          visit[i]=true;
          q.add(i);
        }
      }
    }
    System.out.println(answer-1);
  }
}
