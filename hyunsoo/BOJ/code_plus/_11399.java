package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _11399 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int answer=0;
    int sum=0;
    for(int tmp : arr){
      sum += tmp;
      answer +=sum;
    }
    System.out.print(answer);

  }
}
