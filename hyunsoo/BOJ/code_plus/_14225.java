package BOJ.code_plus;
import java.io.*;
import java.util.*;

public class _14225 {
  
  static boolean[] check;
  static int[] arr;
  static int n;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<n; i++){
      arr[i]= Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    check = new boolean[2000001];

    find(0 , 0);

    for(int i=1; i<2000001; i++){
      if(!check[i]){
        System.out.print(i);
        return;
      }
    }
  }
  public static void find(int select , int sum){
    
    if(select == n){
      return;
    }
    
    check[sum]=true;
    check[sum+arr[select]]= true;
    find(select+1, sum+arr[select]);  
    find(select+1, sum);
    
  }

}
