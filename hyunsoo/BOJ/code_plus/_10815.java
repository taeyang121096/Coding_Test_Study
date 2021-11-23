package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _10815 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    HashSet<Integer> hs = new HashSet<>();
  
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    for(int i=0; i<n; i++){
      hs.add(Integer.parseInt(st.nextToken()));
    }
    
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine()," ");
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<m; i++){
      int tmp = Integer.parseInt(st.nextToken());
      if(hs.contains(tmp)) sb.append("1 ");
      else sb.append("0 ");
    }
    System.out.print(sb.toString());

  }
}
