import java.io.*;
import java.util.*;

public class Super {
    static int n;
    static int m;
    static int[][] mat;
    static List<int[]> cate = new ArrayList<>();
    static int blank=0;
    static int ans = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
                if (mat[i][j] > 0 && mat[i][j] < 6) {
                    list.add(mat[i][j]);
                }
                if(mat[i][j] == 0)
                    blank++;
            }
        }
        make(list, new int[list.size()],0);
        fill();
        System.out.println(ans);
    }

    static void fill(){

        for(int[] dir : cate) {
            boolean [][] check = new boolean[n][m];
            int bl = blank;
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] > 0 && mat[i][j] < 6) {
                        bl = go(dir,index++,bl,check,i,j);
                    }
                }
            }
            ans = Math.min(ans,bl);
        }
    }
    static int go(int[] tmp,int index,int blank,boolean[][]check,int row,int col){
        int dir = tmp[index];
        if(mat[row][col] == 1){
            if(dir == 0){
                blank = move(0,blank,check,row,col);
            }
            else if(dir == 1){
                blank = move(1,blank,check,row,col);
            }
            else if(dir == 2){
                blank = move(2,blank,check,row,col);
            }
            else if(dir == 3){
                blank = move(3,blank,check,row,col);
            }
        }else if(mat[row][col] == 2){
            if(dir == 0){
                blank = move(2,blank,check,row,col);
                blank = move(0,blank,check,row,col);
            }
            else if(dir == 1){
                blank = move(1,blank,check,row,col);
                blank = move(3,blank,check,row,col);
            }
        }
        else if(mat[row][col] == 3){
            if(dir == 0){
                blank = move(3,blank,check,row,col);
                blank = move(0,blank,check,row,col);
            }
            else if(dir == 1){
                blank = move(0,blank,check,row,col);
                blank = move(1,blank,check,row,col);
            }
            else if(dir == 2){
                blank = move(1,blank,check,row,col);
                blank = move(2,blank,check,row,col);
            }
            else if(dir == 3){
                blank = move(2,blank,check,row,col);
                blank = move(3,blank,check,row,col);
            }
        }
        else if(mat[row][col] == 4){
            if(dir == 0){
                blank = move(2,blank,check,row,col);
                blank = move(3,blank,check,row,col);
                blank = move(0,blank,check,row,col);
            }
            else if(dir == 1){
                blank = move(3,blank,check,row,col);
                blank = move(0,blank,check,row,col);
                blank = move(1,blank,check,row,col);
            }
            else if(dir == 2){
                blank = move(0,blank,check,row,col);
                blank = move(2,blank,check,row,col);
                blank = move(1,blank,check,row,col);
            }
            else if(dir == 3){
                blank = move(2,blank,check,row,col);
                blank = move(1,blank,check,row,col);
                blank = move(3,blank,check,row,col);
            }
        }else{
            blank = move(0,blank,check,row,col);
            blank = move(1,blank,check,row,col);
            blank = move(2,blank,check,row,col);
            blank = move(3,blank,check,row,col);
        }

        return blank;
    }
    static int move(int dir,int blank, boolean[][]check,int row,int col){
        if(dir == 0){
            if(col+1 < m &&mat[row][col+1] !=6){
                if(check[row][col+1] != true && mat[row][col+1] ==0){
                    check[row][col+1] = true;
                    blank--;
                }
                blank = move(dir,blank,check,row,col+1);

            }
        }
        else if(dir == 1){
            if(row+1 < n &&mat[row][col+1] !=6){
                if(check[row+1][col] != true&&mat[row+1][col] ==0){
                    check[row+1][col] = true;
                    blank--;
                }
                blank =move(dir,blank,check,row+1,col);

            }

        }
        else if(dir == 2){
            if(col-1 >= 0 &&mat[row][col-1] !=6){
                if(check[row][col-1] != true&&mat[row][col-1] ==0){
                    check[row][col-1] = true;
                    blank--;
                }
               blank =move(dir,blank,check,row,col-1);
            }

        }
        else if(dir == 3){
            if(row - 1>= 0&&mat[row-1][col] !=6){
                if(check[row-1][col] != true&&mat[row-1][col] ==0){
                    check[row-1][col] = true;
                    blank--;
                }
               blank = move(dir,blank,check,row-1,col);

            }

        }
        return blank;
    }

    static void make(List<Integer> list, int[] tmp,int level) {
        if(level == list.size()){
            int[] ca = new int[list.size()];
            ca = tmp.clone();
            cate.add(ca);
            return;
        }


        for(int dir = 0;dir<4;dir++){
            if(list.get(level) == 2 && dir >1)
                continue;
            if(list.get(level) == 5 && dir >0)
                continue;
            tmp[level] = dir;
            make(list,tmp,level+1);
        }

    }
}
