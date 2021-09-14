package BOJ.basicCheck;
import java.util.*;
public class _2501 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N= sc.nextInt();
    int K= sc.nextInt();

    int index=0;
    for(int i=1; i<=N; i++){
      if(N%i==0) index++;
      if(index==K){
        System.out.println(i);
        return;
      }
    }

    System.out.println(0);

  }
}
