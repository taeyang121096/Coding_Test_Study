package School;

import java.util.*;

public class Count {
    static int[] ans;
    static int[] number;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ans = new int[n+1];
        number = new int[n+1];
        String num[] = sc.nextLine().split(" ");
        for(int i = 1;i<=n;i++)
            number[i] = Integer.parseInt(num[i-1]);
        for(int i = 2;i<=n;i++){
            int count = 1;
            int max = number[i-1];
            for(int j = i-2;j>=1;j--){
                if(max < number[j]){
                    count++;
                    max = number[j];
                }
            }
            ans[i] = count;
        }
        int sum = Arrays.stream(ans).sum();
        System.out.println(sum);
    }
}
