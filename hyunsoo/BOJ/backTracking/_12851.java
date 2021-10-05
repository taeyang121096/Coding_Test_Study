package BOJ.backTracking;
import java.util.*;
public class _12851 {
  
  static int n,k;
  static int fast=Integer.MAX_VALUE;
  static boolean[] visit=new boolean[100001];
  static int count=0;

  static class node{
    int index;
    int time;
    public node(int index, int time){
      this.index=index;
      this.time=time;
    }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    n=sc.nextInt();
    k=sc.nextInt();
    
    back(n,0);

    System.out.println(fast);
    System.out.println(count);
  }

  public static void back(int index, int time){
    
    Queue<node> q = new LinkedList<>();
    q.offer(new node(index,time));
    visit[index]=true;

    while(!q.isEmpty()){
      node tmp = q.poll();
      visit[tmp.index]=true;
      if(tmp.index==k){
        if(fast==Integer.MAX_VALUE){
          fast=tmp.time;
          count=1;
        }else{
          if(tmp.time==fast){
            count++;
          }
        }
      }

      int a = tmp.index+1;
      int b = tmp.index-1;
      int c = tmp.index*2;

      if(a<=100000 && !visit[a]){
        q.offer(new node(a,tmp.time+1));
      }

      if(b>=0 && !visit[b]){
        q.offer(new node(b,tmp.time+1));
      }
      if(c<=100000 && !visit[c]){  
        q.offer(new node(c,tmp.time+1));
      }
    }
  }
}
