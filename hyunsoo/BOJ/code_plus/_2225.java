package BOJ.code_plus;
import java.util.*;
import java.math.*;
public class _2225 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int N = n + k - 1;
    int r = n;
   

    BigInteger num = BigInteger.ONE;
    BigInteger num1 = BigInteger.ONE;
    for(int i=N; i>N-r; i--){
      num = num.multiply(BigInteger.valueOf(i));
    }

    for(int i=r; i>=1; i--){
      num1 = num1.multiply(BigInteger.valueOf(i));
    }
  
    num  = num.divide(num1);
    num = num.remainder(BigInteger.valueOf(1000000000));
    System.out.print(num.toString());
    
  }
}
