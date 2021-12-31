package basic;

import java.util.*;
public class Prime {

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int count = 0;
        String[] num = sc.nextLine().split(" ");
        for(int i = 0;i<num.length;i++){
            if(prime(Integer.parseInt(num[i])))
                count++;
        }
        System.out.println(count);
    }
    static boolean prime(int num){
        if(num == 1)
            return false;
        for(int i = 2;i<num;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}
