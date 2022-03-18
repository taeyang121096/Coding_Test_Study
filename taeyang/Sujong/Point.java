package Sujong;
import java.util.*;
import java.io.*;
/*

    a,b,c < 21억 int

    if(b >= c) retrun -1
    minus = c-b
    cnt = a/minus +1



 */
public class Point {

    public static void main(String[] args) throws IOException {
//        선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
//        초기화
        int idx = 0;

        for(String s : str){
            arr[idx++] = Integer.parseInt(s);
        }
//        로직
        if(arr[1] >= arr[2]) {
            System.out.println("-1");
            System.exit(0);
        }

        int minus = arr[2] - arr[1];
        int cnt = arr[0]/minus+1;

//        출력
        System.out.println(cnt);



    }
}
