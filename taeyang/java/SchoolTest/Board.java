package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            String[] num = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(num[0]);
            int y1 = Integer.parseInt(num[1]);
            int x2 = x1 + Integer.parseInt(num[2]);
            int y2 = y1 + Integer.parseInt(num[3]);
            list.add(new int[]{x1,x2,y1,y2});
        }
        String[] candi = sc.nextLine().split(" ");
        int w = Integer.parseInt(candi[0]);
        int h = Integer.parseInt(candi[1]);
        int m = Integer.parseInt(candi[2]);

        for(int i = 0;i<m;i++){
            String[] num = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(num[0]);
            int y1 = Integer.parseInt(num[1]);
            int x2 = x1 + w;
            int y2 = y1 + h;
            if(check(x1,x2,y1,y2))
                System.out.println("OKAY");
            else
                System.out.println("NO");
        }
    }
    static boolean check(int x1,int x2, int y1, int y2){
        for(int[] arr: list){
            if(((arr[0] < x1 && x1 < arr[1])||(arr[0]< x2 && x2<arr[1])) && ((arr[2] < y1 && y1 < arr[3])||(arr[2]< y2 && y2<arr[3])))
                return false;
            if((arr[0] == x1 && arr[1] == x2) && (arr[2] == y1 && arr[3] ==y2))
                return false;
            if((arr[0] == x1 && arr[1] == x2) && ((arr[2] < y1 && y1 < arr[3])||(arr[2]< y2 && y2<arr[3])))
                return false;
            if((arr[2] == y1 && arr[3] == y2) && ((arr[0] < x1 && x1 < arr[1])||(arr[0]< x2 && x2<arr[1])))
                return false;
        }
        return true;
    }
}
