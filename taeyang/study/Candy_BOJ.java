import java.io.*;
import java.util.StringTokenizer;

public class Candy_BOJ {
    static int[][] mat;
    static int max = 0;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;

    static void count(){
        for(int i = 0;i<n;i++){
            int cnt = 0;
            int val = 0;
            for(int j = 0;j<n;j++){
                if(j == 0) {
                    val = mat[i][j];
                    cnt++;
                    continue;
                }
                if(val == mat[i][j])
                    cnt++;
                else{
                    val = mat[i][j];
                    max = Math.max(max,cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max,cnt);
        }
        for(int i = 0;i<n;i++){
            int cnt = 0;
            int val = 0;
            for(int j = 0;j<n;j++){
                if(j == 0) {
                    val = mat[j][i];
                    cnt++;
                    continue;
                }
                if(val == mat[j][i])
                    cnt++;
                else{
                    val = mat[j][i];
                    max = Math.max(max,cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max,cnt);
        }
    }

    static void change() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr>=0&&nr<n&&nc>=0&&nc<n&&mat[r][c] != mat[nr][nc]){
                        int tmp = mat[nr][nc];
                        mat[nr][nc] = mat[r][c];
                        mat[r][c] = tmp;
                        count();
                        mat[r][c] = mat[nr][nc];
                        mat[nr][nc] = tmp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            int index = 0;
            char[] tmp = br.readLine().toCharArray();
            for (char c : tmp) {
                if (c == 'C')
                    mat[i][index++] = 0;
                else if (c == 'P')
                    mat[i][index++] = 1;
                else if (c == 'Z')
                    mat[i][index++] = 2;
                else if (c == 'Y')
                    mat[i][index++] = 3;
            }
        }

        change();


        System.out.println(max);
    }
}
