package Sujong;

import java.io.*;
import java.util.*;

//9개 자연수 중 최댓값은 몇번째?
//1. 1줄에 한개의 수
//2. 자연수 값<100

// 1. max = 0  min = 100, idx =-1
// 2. list
// 3. for -> if( list.get(i) > max -> max = list.get(i), idx = i)

public class Max {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int max = 0;
        int min = 100;
        int idx = -1;


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);


    }
}
