package BOJ.basicCheck;
import java.util.*;
public class _10818 {
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr= new int[N];

    for(int i=0; i<N; i++){
      int tmp = sc.nextInt();
      arr[i]=tmp;
    }
    Arrays.sort(arr);

    System.out.print(arr[0]+" "+arr[N-1]);
  }
}
