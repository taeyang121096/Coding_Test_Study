package BOJ.backTracking;
import java.util.*;
public class _16953 {

  static int A,B;
  static int min=Integer.MAX_VALUE;
  static int last=1000000000;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    A= sc.nextInt();
    B= sc.nextInt();

    back(A+"",1);

    if(min == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(min);
  }
  public static void back(String x, int count){
    
    if(Integer.parseInt(x)==B){
      min=Math.min(min,count);
      return;
    }

    if(Integer.parseInt(x)>B){
      return;
    }

    if(Integer.parseInt(x) <= last/2){
      int mult = Integer.parseInt(x) * 2;
      back(mult+"",count+1);
    }

    if(Integer.parseInt(x)<Integer.MAX_VALUE/10){
      back(x+1,count+1);
    }

  }
}
