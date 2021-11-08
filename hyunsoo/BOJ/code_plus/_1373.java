package BOJ.code_plus;
import java.io.*;
public class _1373 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    String answer="";
    int count = 0;
    double tmp=0;
    for(int i=str.length()-1; i>=0; i--){
      char c = str.charAt(i);
      tmp += (c-'0') * Math.pow(2,count++);
      if(count ==3 ){
        answer = (int)tmp + answer;
        tmp=0;
        count=0;
      }
    }

    answer = (int)tmp + answer;
    System.out.println(answer);
  }
}
