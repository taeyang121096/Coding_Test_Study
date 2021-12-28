package basic;
import java.util.*;
public class LongSub4 {

    static int[] number;
    static int[] dp;
    static List[] list;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] num = sc.nextLine().split(" ");
        number = new int[n];
        dp = new int[n];
        list = new List[n];
        for(int i = 0;i<n;i++)
            list[i] = new ArrayList<String>();
        for(int i = 0;i<n;i++)
            number[i] = Integer.parseInt(num[i]);

        for(int i = 0;i<n;i++){
            dp[i] = 1;

            for(int j = 0;j<i;j++){
                if(number[i]>number[j] && dp[i] < dp[j]+1){
                    list[i].clear();
                    dp[i] = dp[j]+1;
                    for(int index = 0;index<list[j].size();index++)
                        list[i].add(list[j].get(index));
                }
            }
            list[i].add(number[i]);
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
        for(int i = 0;i<n;i++){
            if(list[i].size() == max){
                for(int j = 0;j<max;j++)
                    System.out.print(list[i].get(j)+" ");
                break;
            }
        }
    }
}
