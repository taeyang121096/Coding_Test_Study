package basic;

import java.util.*;

public class ChangeTen {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String num[] = sc.nextLine().split(" ");
        String n = num[0];
        int b = Integer.parseInt(num[1]);
        int first = 'A';
        int ans = 0;
        int len = n.length()-1;
        for(int i = 0;i<n.length();i++){
            char c = n.charAt(i);
            if(c >= first){
                int val = c-first +10;
                ans += val*Math.pow(b,len-i);
            }else{
                ans += Character.getNumericValue(c)*Math.pow(b,len-i);
            }

        }
        System.out.println(ans);
    }
}
