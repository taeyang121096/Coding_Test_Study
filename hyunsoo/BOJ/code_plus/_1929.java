package BOJ.code_plus;
import java.util.*;
public class _1929 {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    int m= sc.nextInt();

    StringBuilder sb = new StringBuilder();

    for(int i=n; i<=m; i++){
      if(i==1) continue;
      boolean check = false;
      for(int j=2; j<=Math.sqrt(i); j++){
        if(i%j==0){check = true; break;}
      }
      if(!check) sb.append(i+"\n");
    }
    System.out.print(sb.toString());

  
  }

}
