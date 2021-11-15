package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _15990 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    long[][] arr = new long[4][100001];

    arr[1][1] = 1;
    arr[2][2] = 1;
    arr[1][3] = 1;
    arr[2][3] = 1;
    arr[3][3] = 1;

    for(int i=4; i<=100000; i++){
      arr[1][i] = (arr[2][i-1] + arr[3][i-1])%1000000009;
      arr[2][i] = (arr[1][i-2] + arr[3][i-2])%1000000009;
      arr[3][i] = (arr[1][i-3] + arr[2][i-3])%1000000009;  
    }
    
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<n; i++){
      int tmp = Integer.parseInt(br.readLine());
      long ans = (arr[1][tmp] + arr[2][tmp] + arr[3][tmp]) % 1000000009;
      sb.append(ans+"\n");
    }
    System.out.print(sb.toString());
  }
}
