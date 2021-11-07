package BOJ.code_plus;
import java.io.*;
public class _11655 {
  public static void main(String[] args) throws IOException{
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    String str = br. readLine();
    String answer="";
    for(char c : str.toCharArray()){
      if(c-'a'>=0 && c-'a'<26){
       if(c+13-'a'>=26){
          char t = (char)(c -13);
          answer+=t;
       }else{
         char t = (char)(c+13);
         answer+=t;
       }
      }else if(c-'A'>=0 && c-'A'<26){
        if(c+13-'A'>=26){
          char t = (char)(c -13);
          answer+=t;
       }else{
         char t = (char)(c+13);
         answer+=t;
       }
      }else{
        answer += c;
      }
    }
    System.out.println(answer);
  }
}
