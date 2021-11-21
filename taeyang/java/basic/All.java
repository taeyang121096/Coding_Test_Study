package basic;
import java.util.*;
public class All {

    static int[] arr;
    static void make(){
        int i = arr.length-1;
        while(i>0 && arr[i-1]>=arr[i])i--;
        if(i == 0) return;
        int j = arr.length-1;
        while(arr[j]<=arr[i-1])j--;
        swap(i-1,j);
        j = arr.length -1;
        while(i<j){
            swap(i,j);
            i++;
            j--;
        }
        for(int k = 0;k< arr.length;k++)
            System.out.print(arr[k]+" ");
        System.out.println();

    }
    static void swap(int f,int s){
        int tmp = arr[f];
        arr[f] = arr[s];
        arr[s] = tmp;

    }
    static int factorial(int n){
        int cnt = 1;
        for(int i =1;i<=n;i++)
            cnt *=i;
        return cnt;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = i+1;
        }
        int count = factorial(n);

        for(int i = 0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        for(int i = 2;i<=count;i++)
            make();


    }
}
