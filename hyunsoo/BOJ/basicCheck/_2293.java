package BOJ.basicCheck;
import java.util.*;

public class _2293 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] tmp = sc.nextLine().split(" ");
    int n= Integer.parseInt(tmp[0]);
    int k= Integer.parseInt(tmp[1]);

    int[] coin= new int[n];
    for(int i=0; i<n; i++){
      coin[i]=Integer.parseInt(sc.nextLine());
    }
    Arrays.sort(coin);

  
    int[] answer= new int[k+1];
    answer[0]=1;
    for(int i=0; i<n; i++){
      for(int j=coin[i]; j<=k; j++){
        answer[j] += answer[j-coin[i]];
      }
    }

    System.out.println(answer[k]);
  }
}
