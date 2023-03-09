package BOJ;

import java.util.*;
import java.io.*;

public class IQTest_BOJ {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1){
            System.out.println("A");
            return;
        } else if(n == 2){
            if(arr[0] == arr[1]){
                System.out.println(arr[0]);
                return;
            }
            System.out.println("A");
            return;
        }

        boolean flag = true;
        int a = 0;
        int b = 0;
        for(int i = 0; i < n - 1; i++){
            if(i == 0){
                int first = arr[0];
                int second = arr[1];
                int third = arr[2];
                if(second - first == 0){
                    a = 1;
                    b = 0;
                } else {
                    a = (third - second) / (second - first);
                    b = second - (a * first);
                }
            }
            int now = (arr[i] * a) + b;
            int next = arr[i+1];
            if(now != next){
                flag = false;
                break;
            }
        }
        if(!flag){
            System.out.println("B");
            return;
        }
        System.out.println(arr[n-1] * a + b);

    }
}