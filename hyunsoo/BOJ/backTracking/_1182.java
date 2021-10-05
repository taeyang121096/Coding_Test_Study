package BOJ.backTracking;
import java.util.*;
public class _1182 {

  static int N,S;
  static int[] arr;
  static int answer=0;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] tmp = sc.nextLine().split(" ");

    N = Integer.parseInt(tmp[0]);
    S = Integer.parseInt(tmp[1]);

    arr=new int[N];
    for(int i=0; i<N; i++){
      arr[i]=sc.nextInt();
    }

    Arrays.sort(arr);
    back(0,0);
    if(S==0) System.out.println(answer-1);
    else System.out.println(answer);
  }

  public static void back(int sum,int index){
    if(index==N){
      if(sum==S) answer++;
      return;
    }

    back(sum+arr[index], index+1);
    back(sum, index+1);
  }
}
