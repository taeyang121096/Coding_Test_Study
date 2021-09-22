import java.util.*;
public class PrimeFind {

    static boolean prime(int n){
        if(n<=1)
            return false;
        for(int i =2;i<=Math.sqrt(n);i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            int num = sc.nextInt();
            if(prime(num))
                ans++;
        }
        System.out.println( ans);
    }

}
