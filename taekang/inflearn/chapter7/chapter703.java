package inflearn.chapter7;

import java.io.*;
import java.util.*;

public class chapter703 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        recur(1, 1);
    }

    public static void recur(int N, int Sum) {
        if (N == 0) {
            System.out.println(Sum);
            return;
        } else {
            recur(N - 1, Sum * N);
        }
    }
}
