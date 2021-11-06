package basic;
import java.util.*;
public class Rest {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        int a = Integer.valueOf(num[0]);
        int b = Integer.valueOf(num[1]);
        int c = Integer.valueOf(num[2]);

        System.out.println((a+b)%c);
        System.out.println(((a%c)+(b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c)*(b%c))%c);

    }
}
