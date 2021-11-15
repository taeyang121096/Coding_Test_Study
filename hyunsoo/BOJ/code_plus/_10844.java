package BOJ.code_plus;
import java.util.*;
public class _10844 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n =sc.nextInt();

    long[][] arr = new long[n+1][10];

    for(int i=1; i<10; i++){
      arr[1][i]=1;
    }

    for(int i=2; i<=n; i++){
      for(int j=0; j<10; j++){
        if(j==0){
          arr[i][j] = (arr[i][j] + arr[i-1][1])%1000000000;
        }else if(j==9){
          arr[i][j] = (arr[i][j] + arr[i-1][8])%1000000000;
        }else{
          arr[i][j] = (arr[i][j] + arr[i-1][j-1] + arr[i-1][j+1])%1000000000;
        }
      }
    }

    long ans =0;

    for(int i=0; i<10; i++){
      ans+=arr[n][i];
    }
    System.out.println(ans%1000000000);
  }
}
