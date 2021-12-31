package basic;
import java.util.*;
public class MaxVal {
    static int[]arr;
    static int max = 0;
    static int calc(){
        int sum = 0;
        for(int i = 0;i<arr.length-1;i++){
            sum += Math.abs(arr[i]-arr[i+1]);
        }
        return sum;
    }
    static int factorial(int n){
        int cnt = 1;
        for(int i = 1;i<=n;i++)
            cnt *= i;
        return cnt;
    }
    static void make(){

        int i = arr.length-1;
        while(i>0&&arr[i-1]>=arr[i])i--;
        if(i==0)return;
        int j = arr.length-1;
        while(arr[j]<=arr[i-1])j--;
        swap(i-1,j);
        j = arr.length-1;
        while(i<j){
            swap(i,j);
            i++;
            j--;
        }
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
        String num[] = sc.nextLine().split(" ");
        for(int i = 0;i<n;i++)
            arr[i] = Integer.parseInt(num[i]);
        Arrays.sort(arr);
        max = Math.max(max,calc());
        int count = factorial(n);
        for(int i = 2;i<=count;i++){
            make();
            max = Math.max(max,calc());
        }
        System.out.println(max);
    }
}
