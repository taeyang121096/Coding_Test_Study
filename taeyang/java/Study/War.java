import java.util.*;

public class War {
    static int[][] mat;
    static int count;
    static int n ;
    static int m;
//W = 1 B = 0 n= 가로 m = 세로
//    상(-1,0) 하(1,0) 좌(0,-1) 우(0,1)
    static void dfs(int row, int col,int value){
        count++;
        mat[row][col] = -1;
        if(row -1 >=0 && mat[row-1][col] == value )
            dfs(row-1,col,value);
        if(row +1 < m && mat[row+1][col] == value )
            dfs(row+1,col,value);
        if(col -1 >=0 && mat[row][col-1] == value )
            dfs(row,col-1,value);
        if(col +1 < n && mat[row][col+1] == value )
            dfs(row,col+1,value);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        mat = new int[m][n];
        int white =0;
        int blue = 0;

        for(int i = 0;i<m;i++){
            String str = sc.next();
            for(int j = 0;j<n;j++){
                if(str.charAt(j) == 'W')
                    mat[i][j] = 1;
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){

                if(mat[i][j] == -1)
                    continue;
                count = 0;
                int cate = mat[i][j];
                dfs(i,j,mat[i][j]);
                if(cate == 1)
                    white += (int)Math.pow(count,2);
                else
                    blue += (int)Math.pow(count,2);

            }
        }
        System.out.println(white+" "+ blue);

    }
}
