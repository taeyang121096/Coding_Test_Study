package BOJ.nhnCommerce;
import java.util.*;
import java.io.*;
public class _1662 {
  
  static String[] stack = new String[51];
  static int point=0;
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int answer =0;
    int leng = input.length();
    
    for(int i=0; i<leng; i++){
      char t = input.charAt(i);
      String outStr="";
      if(t != ')'){ 
        stack[point++]=String.valueOf(t);
      }else{
        String out = stack[--point];
        while(!out.equals("(")){
          outStr= out+outStr;
          out = stack[--point];
        }
        out = stack[--point];
        String tmp="";
        for(int j=0; j<Integer.parseInt(out); j++){
          tmp += outStr;
        }
        stack[point++]=tmp;
      }
    }

  
    for(int i=0; i<point; i++){
      answer += stack[i].length();
    }
    System.out.println(answer);
  }
}
