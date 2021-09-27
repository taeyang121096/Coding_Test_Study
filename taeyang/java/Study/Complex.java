import java.util.*;
public class Complex {

    static List<Integer> res = new ArrayList<>();
    static int[][] Board;
    static int count = 0;
//    상 하 좌 우
    static void dfs(int row, int col){
        Board[row][col] = 0;
        count++;
        for(int i = 0;i<4;i++){
            if(i == 0 && row -1 >= 0 && Board[row-1][col] == 1){
                dfs(row-1,col);
            }
            else if(i ==1 && row+1 < Board.length && Board[row+1][col] == 1){
                dfs(row+1,col);
            }
            else if(i ==2 && col-1 >=0&&Board[row][col-1] == 1){
                dfs(row,col-1);
            }
            else if(i == 3 && col+1 < Board.length && Board[row][col+1] == 1){
                dfs(row,col+1);
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Board = new int[n][n];
        for(int i = 0;i<n;i++){
            String str = sc.next();
            for(int j = 0;j<n;j++)
                Board[i][j] = Character.getNumericValue(str.charAt(j));
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(Board[i][j] == 1) {
                    dfs(i, j);
                    res.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for(int x : res)
            System.out.println(x);
    }
}
