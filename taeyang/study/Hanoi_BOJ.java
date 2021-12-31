

import java.io.*;
public class Hanoi_BOJ {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static void hanoi(int from,int tmp,int to,int n){
        if(n == 0)
            return;
        hanoi(from,to,tmp,n-1);
        sb.append(String.valueOf(from)+" "+String.valueOf(to)+"\n");
        count++;
        hanoi(tmp,from,to,n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(1,2,3,n);
        System.out.println(count);
        System.out.println(sb.toString());
    }

}
