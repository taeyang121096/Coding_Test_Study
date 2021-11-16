package Kyonggi_Algorithm_Competition;
import java.util.*;

public class _1 {
  public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int multi15 = N/15;
		int multi3 = N/3;
		
		System.out.println(multi3-multi15);
	}
}
