package School;

import java.util.Scanner;
import java.util.*;

public class GoodMat {

    static int[] number = new int[9];
    static boolean[] flag = new boolean[9];
    static int[][] mat = new int[3][3];
    static List<int[][]> list = new ArrayList<>();
    static void make(int level,int index){
        if(level == 3){
            int[][]arr = new int[3][3];
            for(int i = 0;i<3;i++)
                arr[i] = mat[i].clone();
            list.add(arr);
            return;
        }
        for(int i = 0;i<9;i++){
            if(flag[i])
                continue;
            mat[level][index] = number[i];
            flag[i] = true;
            if(index+1 ==3)
                make(level+1,0);
            else
                make(level,index+1);
            flag[i] = false;
        }
    }
    static boolean calc(){
        for(int[][] tmp : list){
            int val = 0;
            boolean flag = false;
            for(int i = 0;i<3;i++){
                int v1 = 0;
                for(int j=0;j<3;j++){
                    v1 += tmp[i][j];
                }
                if(i==0)
                    val = v1;
                if(val != v1){
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;
            for(int i = 0;i<3;i++){
                int v2 = 0;
                for(int j=0;j<3;j++){
                    v2 += tmp[j][i];
                }
                if(val != v2){
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;
            if(val != tmp[0][0]+tmp[1][1]+tmp[2][2])
                continue;
            if(val != tmp[0][2]+tmp[1][1]+tmp[2][0])
                continue;
            return true;
        }
        return false;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        for(int i =0;i<5;i++) {
            list.clear();
            String[] num = sc.nextLine().split(" ");
            int index = 0;
            for (String n : num)
                number[index++] = Integer.parseInt(n);
            make(0, 0);
            if(calc())
                System.out.println("YES");
            else
                System.out.println("NO");
        }




    }
}
