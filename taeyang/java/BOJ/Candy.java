package basic;

import java.util.*;
public class Candy {

    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] mat = new char[n][n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            String str = sc.nextLine();
            for(int j = 0;j<n;j++){
                mat[i][j] = str.charAt(j);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int[] d : dir){
                    if(i+d[0] >= 0 && j+d[1] >=0 && i+d[0]<n&&j+d[1]<n&&mat[i][j] != mat[i+d[0]][j+d[1]]){
                        char[][] tmp = new char[n][n];
                        for(int r = 0;r<n;r++){
                            tmp[r] = mat[r].clone();
                        }
                        ans = Math.max(ans,change(tmp,new int[]{i,j},new int[]{i+d[0],j+d[1]}));
                    }

                }
            }
        }
        System.out.println(ans);

    }
    static int change(char[][] t,int[] pre, int[] post){
        char tmp = t[post[0]][post[1]];
        t[post[0]][post[1]] = t[pre[0]][pre[1]];
        t[pre[0]][pre[1]] = tmp;
        return count(t);
    }
    static int count(char[][]t){
        int cnt = 0;
        for(int i=0;i<t.length;i++){
            char com = t[i][0];
            int count = 1;
            for(int j = 1;j<t.length;j++){
                if(com != t[i][j]){
                    com = t[i][j];
                    cnt = Math.max(cnt,count);
                    count = 0;
                }
                count++;
            }
            cnt = Math.max(cnt,count);
        }
        for(int i=0;i<t.length;i++){
            char com = t[0][i];
            int count = 1;
            for(int j = 1;j<t.length;j++){
                if(com != t[j][i]){
                    com = t[j][i];
                    cnt = Math.max(cnt,count);
                    count = 0;
                }
                count++;
            }
            cnt = Math.max(cnt,count);
        }
        return cnt;
    }
}
