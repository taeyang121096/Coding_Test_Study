package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _1149 {
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] red = new int[N+1];
    int[] green = new int[N+1];
    int[] blue = new int[N+1];
    
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int r = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      red[i]= Math.min(green[i-1],blue[i-1]) + r;
      green[i] = Math.min(red[i-1],blue[i-1]) + g;
      blue[i] = Math.min(red[i-1],green[i-1]) + b;
    }

    int answer = Math.min(red[N], Math.min(green[N],blue[N]));
    System.out.print(answer);
  }
}
