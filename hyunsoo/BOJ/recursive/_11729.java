package BOJ.recursive;
import java.util.*;
public class _11729 {
  
  static StringBuilder sb = new StringBuilder();
  static long answer=0;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    hanoi(n,1,2,3);

    System.out.println(answer);
    System.out.print(sb.toString());
  }

  public static void hanoi(int N, int a, int b, int c){
    if(N==1){
      sb.append(a+" "+c+"\n");
      answer++;
      return;
    }

    hanoi(N-1, a, c, b);

    answer++;
    sb.append(a+" "+c+"\n");

    hanoi(N-1,b,a,c);

  }
}
