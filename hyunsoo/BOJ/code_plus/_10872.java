package BOJ.code_plus;
import java.util.*;
public class _10872 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();

    int sum =1;
    for(int i=2; i<=n; i++){
      sum *=i;
    }
    System.out.print(sum);
  }
}
