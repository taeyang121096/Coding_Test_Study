package BOJ.dp;
import java.util.*;
public class _9625 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n =sc.nextInt();

    int[] A = new int[46];
    int[] B = new int[46];

    A[0]=1;
    B[0]=0;

    for(int i=1; i<=n; i++){
      B[i] = A[i-1]+B[i-1];
      A[i] = B[i-1];
    }

    System.out.println(A[n]+" "+B[n]);
  }
}
