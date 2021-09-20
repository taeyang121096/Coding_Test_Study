package BOJ.basicCheck;
import java.util.*;
public class _1292 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    int end = sc.nextInt();

    int minus=0;
    int sum=0;
    int last=1;
    int count=0;
    for(int i=1; i<= end; i++){
      if(i<start){
        minus+=last;
      }
      sum+=last;
      count++;
      if(count==last) {last++; count=0;}
    }

    System.out.println(sum-minus);
  }
}
