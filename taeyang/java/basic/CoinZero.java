package basic;

import java.util.*;
public class CoinZero {

    static int[] cost;
    static int count = 0;
    static void calc(int val){

        for(int i = cost.length-1;i>=0;i--){
            if(val == 0)
                break;
            if(val/cost[i] != 0){
                count += val/cost[i];
                val %= cost[i];
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String num[] = sc.nextLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int k = Integer.parseInt(num[1]);
        cost = new int[n];
        for(int i = 0;i<n;i++)
            cost[i] = Integer.parseInt(sc.nextLine());
        calc(k);
        System.out.println(count);
    }
}
