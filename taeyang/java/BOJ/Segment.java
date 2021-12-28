package basic;

import java.util.*;

public class Segment {
static int n;
static int m;
static int max=0;
static int arr[][];
static boolean check[][];
static void dfs(int row,int col){
    if(row >= n){
        sum();
        return;
    }
    if(col>=m){
        dfs(row+1,0);
        return;
    }
    check[row][col] = true;
    dfs(row,col+1);
    check[row][col] = false;
    dfs(row,col+1);
}
static void sum(){
    int res = 0;
    int tmp = 0;
    for(int i = 0;i<n;i++){
        tmp = 0;
        for(int j = 0;j<m;j++){
             if(check[i][j]) {
                 tmp *= 10;
                 tmp += arr[i][j];
             }else{
                 res += tmp;
                 tmp = 0;
             }
        }
        res += tmp;
    }
    for(int i = 0;i<m;i++){
        tmp = 0;
        for(int j = 0;j<n;j++){
            if(!check[j][i]){
                tmp *= 10;
                tmp+=arr[j][i];
            }else{
                res += tmp;
                tmp = 0;
            }
        }
        res += tmp;
    }
    max = Math.max(max,res);
}


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        n = Integer.parseInt(num[0]);
        m = Integer.parseInt(num[1]);
        arr = new int[n][m];
        check = new boolean[n][m];
        for(int i = 0;i<n;i++){
            String str = sc.nextLine();
            for(int j = 0;j<m;j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
                if(arr[i][j] ==0)
                    check[i][j] =true;
            }
        }
        dfs(0,0);
        System.out.println(max );
    }
}
