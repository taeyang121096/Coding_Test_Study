package BOJ.basicCheck;
import java.util.*;
import java.io.*;
public class _2693 {
  public static void main(String[] args) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[] arr= new int[10];
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<T; i++){
      
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<10; j++){
        arr[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      sb.append(arr[7]+"\n");  
    }
    System.out.println(sb.toString());
  }
}
