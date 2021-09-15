package BOJ.basicCheck;
import java.util.*;
public class _2460 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int max = Integer.MIN_VALUE;
    int sum=0;
    for(int i=0; i<10; i++){
      
      int out= sc.nextInt();
      int in= sc.nextInt();

      
      sum = sum-out+in;

      max= Math.max(max,sum);
    }

    System.out.println(max);
  }
}
