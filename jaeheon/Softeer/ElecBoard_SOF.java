import java.util.*;
import java.io.*;


// 소프티어 21년 재직자 대회 예선 - 전광판
public class ElecBoard_SOF {
	
	static int[][] num = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
        };
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
/*
        int[] num0 = {'0','4','3','3','4','3','2','2','1','2'};
        int[] num1 = {'4','0','5','3','2','5','6','2','5','4'};
        int[] num2 = {'3','5','0','2','5','4','3','5','2','3'};
        int[] num3 = {'3','3','2','0','3','2','3','3','2','1'};
        int[] num4 = {'4','2','5','3','0','3','4','2','3','2'};
        int[] num5 = {'3','5','4','2','3','0','1','3','2','1'};
        int[] num6 = {'2','6','3','3','4','1','0','4','1','2'};
        int[] num7 = {'2','2','5','3','2','3','4','0','3','2'};
        int[] num8 = {'1','5','2','2','3','2','1','3','0','1'};
        int[] num9 = {'2','4','3','1','2','1','2','2','1','0'};
        int[] blank = {'6','2','5','5','4','5','6','4','7','6'};
*/
        
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a);
            System.out.println(b);

        }
        
    }
}
