package basic;
import java.util.*;
public class Partition {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        boolean[] dp = new boolean[1000001];
        for(int i = 2;i<=1000000;i++){
            if(prime(i))
                dp[i] = true;
        }
        for(int i = 0;i<t;i++){
            int n = Integer.parseInt(sc.nextLine());
            int count = 0;
            for(int j = 2;j<=n/2;j++){
                if(dp[j] && dp[n-j])
                    count++;
            }
            System.out.println(count);
        }
    }
    static boolean prime(int n1){
        for(int i= 2;i<=Math.sqrt(n1);i++){
            if(n1%i==0)
                return false;
        }
        return true;
    }
}
