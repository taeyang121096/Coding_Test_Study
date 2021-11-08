package basic;
import java.util.*;
public class Factori {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int two = 0;
        int five = 0;
        for(int i = 1;i<=n;i++){
            int tmp = i;
            while(tmp % 2 ==0){
                two++;
                tmp /=2;
            }
            while(tmp%5==0){
                five++;
                tmp /=5;
            }
        }
        System.out.println(Math.min(two,five));
    }
}
