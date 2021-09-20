package BOJ.basicCheck;
import java.util.*;
public class _1978 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();
    int answer=0;
    for(int i=0; i<T; i++){
      boolean check= false;
      int num = sc.nextInt();
      if(num==1) continue;
      for(int j=2; j<=num/2; j++){
        if(num%j==0) { check=true; continue;}
      }
      if(!check) answer++;
    }
    System.out.println(answer);
  }
}
