package BOJ.basicCheck;
import java.util.*;
public class _3460 {
  public static void main(String[] args){
    int start=0;
    int[] arr = new int[100];
    Scanner sc = new Scanner(System.in);
    int T= sc.nextInt();
    StringBuilder sb= new StringBuilder();
    
    for(int i=0; i<T; i++){
      start=0;
      int n =sc.nextInt();
      while(n>0){
        arr[start++]=n%2;
        n=n/2;
      }

      for(int j=0; j<start; j++){
        if(arr[j]==1) sb.append(j+" ");
      }
      sb.append("\n");
    }
    System.out.print(sb.toString());

  }
}
