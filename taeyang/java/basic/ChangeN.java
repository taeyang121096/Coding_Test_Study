package basic;

import java.util.*;
public class ChangeN {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String num[] = sc.nextLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int b = Integer.parseInt(num[1]);
        int first = 'A';
        StringBuilder sb = new StringBuilder();

        while(n !=0){
            if(n%b ==0)
                sb.append(0);
            else{
                if(n%b>=10){

                    sb.append((char)(first+(n%b)-10));
                }else{
                    sb.append(n%b);
                }
            }
            n /=b;
        }

        System.out.println(sb.reverse().toString());
    }
}
