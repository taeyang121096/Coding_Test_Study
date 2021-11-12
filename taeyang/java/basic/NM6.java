package basic;
import java.util.*;
public class NM6 {
    static int m;
    static void make(int[]arr,int start,int level,int[] tmp){
        if(level == m){
            for(int i : tmp){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i = start;i<arr.length;i++){
            tmp[level] = arr[i];
            make(arr,i+1,level+1,tmp);
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        int[] arr = new int[n];
        String []num = sc.nextLine().split(" ");
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(num[i]);
        }
        Arrays.sort(arr);
        make(arr,0,0,new int[m]);
    }
}
