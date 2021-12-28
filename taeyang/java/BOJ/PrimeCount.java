package basic;
import java.util.*;
public class PrimeCount {

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        String [] num = sc.nextLine().split(" ");
        int m = Integer.parseInt(num[0]);
        int n = Integer.parseInt(num[1]);
        for(int i = m;i<=n;i++){
            if(prime(i))
                System.out.println(i);
        }

    }
    static boolean prime(int num){
        if(num == 1)
            return false;
        for(int i =2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}
