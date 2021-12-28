package basic;
import java.util.*;
public class Circle2 {

    static int[][]arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] check;
    static void dfs(int s,int n,int cnt,int cost){
        if(n == s && cost>0){
            min = Math.min(min,cost);
            return;
        }
        for(int i =0;i<arr.length;i++){
            if(arr[n][i]>0){
                if(i == s && cnt == arr.length ){
                    cost += arr[n][i];
                    dfs(s,i,cnt+1,cost);
                }else if(!check[i]){
                    check[i] = true;
                    cost += arr[n][i];
                    dfs(s,i,cnt+1,cost);
                    check[i] = false;
                    cost -= arr[n][i];
                }
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n][n];
        for(int i = 0;i<n;i++){
            String[] num = sc.nextLine().split(" ");
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(num[j]);
        }
        check = new boolean[n];
        check[0] = true;
        dfs(0,0,1,0);
        System.out.println(min);

    }
}
