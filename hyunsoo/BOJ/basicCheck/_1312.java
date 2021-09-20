package BOJ.basicCheck;
import java.util.*;
public class _1312 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int A= sc.nextInt();
    int B=sc.nextInt();
    int n = sc.nextInt();
    int answer = A%B;

    for(int i=0; i<n-1; i++){
      answer*=10;
      answer %=B;
    }
    answer*=10;
    System.out.println(answer/B);
  }
}
