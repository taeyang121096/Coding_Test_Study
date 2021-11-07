package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _10824 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    String A= st.nextToken();
    String B= st.nextToken();
    String C= st.nextToken();
    String D= st.nextToken();

    Long tmp1 = Long.parseLong(A+B);
    Long tmp2 = Long.parseLong(C+D);
    
    System.out.print(tmp1+tmp2);
  }
}
