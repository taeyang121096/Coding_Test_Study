package basic;

import java.util.Scanner;

public class Pre {
    static int[] arr;
    static boolean change(){
        int i = arr.length-1;
        while(i>0 && arr[i-1] <= arr[i])i--;
        if(i==0) return false;
        int j = arr.length-1;
        while(arr[j]>=arr[i-1])j--;
        swap(i-1,j);
        j = arr.length-1;
        while(i<j){
            swap(i,j);
            i++;
            j--;
        }
        return true;
    }
    static void swap(int s, int f){
        int tmp = arr[s];
        arr[s] = arr[f];
        arr[f] = tmp;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n];
        String str[] = sc.nextLine().split(" ");
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        if(change()){
            for(int i : arr)
                System.out.print(i+" ");
        }else
            System.out.println(-1);

    }
}
