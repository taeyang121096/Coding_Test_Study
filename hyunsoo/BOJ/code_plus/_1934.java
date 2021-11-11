package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _1934 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    for(int i=0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int input1 = Integer.parseInt(st.nextToken());
      int input2 = Integer.parseInt(st.nextToken());
      

      int a,b,r;  
      if(input1>=input2){
        a=input1;
        b=input2;
      }else{
        b=input1;
        a=input2;
      }

      
      while(b!=0){
        r=a%b;
        a=b;
        b=r;
      }

      sb.append(input1*input2/a+"\n").append("\n");
    }
    System.out.println(sb.toString());
  }
}
