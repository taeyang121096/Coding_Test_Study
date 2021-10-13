package BOJ.samsungSW;
import java.io.*;
import java.util.*;
public class _13458 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr= new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<n; i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine()," ");
    int b=Integer.parseInt(st.nextToken());
    int c=Integer.parseInt(st.nextToken());

    long count=n;
    int i=0;
    while(i<n){
      arr[i] -=b;

      if(arr[i]>0){

        int tmp = arr[i]/c;
        if(arr[i]%c!=0) tmp++;
        count += tmp;
      }
      
      i++;
    }
    System.out.println(count);
  }  
}
