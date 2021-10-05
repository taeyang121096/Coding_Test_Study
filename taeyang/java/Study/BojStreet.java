import java.util.*;

public class BojStreet {


//    n 개 도로 1 ~ n
//    start =1 link = n
//    b,o,j ->    1 = b  k칸 움직이는데 k*k 든다

    static final int MAX = 2000000;
    static int[] dp = new int[1001];
    static char[] ch = new char[]{'B','O','J'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        Arrays.fill(dp, MAX);

        dp[1] = 0;

        for (int j = 0; j < n - 1; j++) {
            char tmp = ch[j%3];
            for(int i = 0;i<str.length();i++){
                if(tmp == str.charAt(i)){
                    char com = ch[(j+1)%3];
                    for(int k = i;k<str.length();k++){
                        if(com == str.charAt(k)){
                            dp[k+1] = Math.min(dp[i+1] + (k-i)*(k-i),dp[k+1]);
                        }
                    }
                }
            }

        }
        if(dp[n] == MAX )
            System.out.println(-1);
        else
            System.out.println(dp[n]);


    }
}
