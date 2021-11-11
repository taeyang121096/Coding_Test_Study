package BOJ.code_plus;
import java.util.*;
public class _1476 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int E = sc.nextInt();
    int S = sc.nextInt();
    int M = sc.nextInt();

    int x1 =0, x2=0, x3=0;

    while(true){
      int t1 = 15 * x1 + E;
      int t2 = 28 * x2 + S;
      int t3 = 19 * x3 + M;

      if(t1 == t2 && t2== t3) {
        System.out.println(t1);
        return;
      }
      int max = Math.max(t1, Math.max(t2,t3));

      if(t1==max){
        if(t2<max) x2++;
        if(t3<max) x3++;
      }else if(t2==max){
        if(t1<max) x1++;
        if(t3<max) x3++;
      }else if(t3==max){
        if(t1<max) x1++;
        if(t2<max) x2++;
      }
    }
  }
}
