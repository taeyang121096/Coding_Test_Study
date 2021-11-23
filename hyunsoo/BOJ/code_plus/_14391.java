package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _14391 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr= new int[n][m];

    for(int i=0; i<n; i++){
      String[] str = br.readLine().split("");
      for(int j=0; j<m; j++){
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }


  }
}
