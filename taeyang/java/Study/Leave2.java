import java.util.*;
public class Leave2 {
//   t = 걸리는 기간 p = 금액  n = 날짜
    static class Teach{
        int time;
        int pay;
        public Teach(int time, int pay){
            this.time = time;
            this.pay = pay;
        }
}
    static Teach[] t ;
    static int[] dp;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        t = new Teach[n+2];
        dp = new int[n+2];
        for(int i = 1;i<=n;i++){
            int time = sc.nextInt();
            int pay = sc.nextInt();
            t[i] = new Teach(time,pay);
        }
        t[n+1] = new Teach(0,0);
        int max = 0;


        for(int i = 1;i<=n+1;i++){
            max = Math.max(max,dp[i]);
            int index = i+t[i].time;
            if(index < n+2)
                dp[index] = Math.max(dp[index],max+t[i].pay);
        }
        System.out.println(dp[n+1]);

    }
}
