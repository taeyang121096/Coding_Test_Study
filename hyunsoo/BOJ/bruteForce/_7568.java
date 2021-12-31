package BOJ.bruteForce;

import java.io.*;

public class _7568 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] x = new int[n];
    int[] y = new int[n];
    int[] rank = new int[n];

    for(int i=0; i<n; i++){
      String[] input = br.readLine().split(" ");
      x[i] = Integer.parseInt(input[0]);
      y[i] = Integer.parseInt(input[1]);
      rank[i] = 1;
    }

    for(int i=0; i<n; i++){
      for(int j=i+1; j<n; j++){
        if(x[i] > x[j]  && y[i] > y[j] ) rank[j]++;
        else if(x[i] < x[j]  && y[i] < y[j]) rank[i]++;
      }
    }

    StringBuilder sb = new StringBuilder();

    for(int i=0; i<n; i++) sb.append(rank[i]+" ");

    System.out.print(sb.toString());
  }  
}
