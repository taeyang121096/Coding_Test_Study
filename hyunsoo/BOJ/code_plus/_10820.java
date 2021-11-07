package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _10820 {
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n=0;
    String str="";

    while((str=br.readLine())!=null){
     
      int L=0, l=0, space =0, num=0;
     
      for(char c : str.toCharArray()){
        if(c==' '){
          space++;
        }else if(c-'0'>=0 && c-'0'<=9){
          num++;
        }else if(c-'a'>=0 && c-'a'<26){
          l++;
        }else{
          L++;
        }
      }
      sb.append(l+" ").append(L+" ").append(num+" ").append(space+"\n");
    }
    System.out.println(sb.toString());
  
  }
}
