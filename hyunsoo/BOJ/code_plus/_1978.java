package BOJ.code_plus;
import java.util.*;
public class _1978 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int answer=0;
    for(int i=0; i<n; i++){
      boolean check=false;
      int tmp = sc.nextInt();
      if(tmp==1) continue;
      
      for(int j=2; j<tmp/2+1; j++){
        if(tmp%j==0){check=true; break;}
      }
      
      if(!check) answer++;
    }
    System.out.print(answer);

  }
}
