package SWEA;

import java.io.*;
import java.util.*;

public class SW_1240 {
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]); // 10
            int m = Integer.parseInt(str[1]); // 70

            String[] arr = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String num = br.readLine();
                for (int j = 0; j < 10; j++) {
                    if (num.contains(arr[j])) {
                        num = num.replace(arr[j], String.valueOf(j));
                    }
                }
                list.add(num);
            }

            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
