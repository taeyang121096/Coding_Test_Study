package basic;
import java.util.*;
public class Four {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        String first = num[0]+num[1];
        String second = num[2]+num[3];

        long val = Long.valueOf(first) + Long.valueOf(second);
        System.out.println(val);


    }
}
