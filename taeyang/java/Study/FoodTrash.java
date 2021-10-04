import java.util.*;
public class FoodTrash {
//    1<= 세로 n<=100, 1<=m<= 100
//    k = 음식물 개수 1<= k <= n*m k = (r,c)
//    상하좌우 만 인접
    static int[][] mat;
    static int count = 0;
    static int[][] dis ={{-1,0},{1,0},{0,-1},{0,1}};
    static void init(int row, int col){
        mat[row][col] = 1;
    }
    static void check(int row,int col){
        mat[row][col] = 0;
        for(int i = 0;i<4;i++){
            int nr = row + dis[i][0];
            int nc = col + dis[i][1];
            if(nr >=0 && nr < mat.length && nc >=0 && nc < mat[0].length && mat[nr][nc] == 1) {
                count++;
                check(nr, nc);
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        mat = new int[n+1][m+1];
        for(int i = 0;i<k;i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            init(r,c);
        }
        
        for(int r = 1;r<=n;r++){
            for(int c =1;c<=m;c++){
                if(mat[r][c] == 1){
                    count++;
                    check(r,c);
                    ans = Math.max(ans,count);
                    count = 0;
                }
            }
        }

        System.out.println(ans);
    }
}
