package Programmers;

import java.util.*;

public class plus_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();

            // scan으로 입력된 String을 빈칸으로 split해서 String 배열으로 저장
            String[] str = input.split(" ");

            for (int k = 0; k < str.length; k++) {
                // String 배열을 char배열으로 변경 후 swap을 진행
                char[] arr = str[k].toCharArray();
                for (int j = 0; j < arr.length / 2; j++) {
                    char temp = arr[j];
                    arr[j] = arr[arr.length - 1 -j];
                    arr[arr.length - 1 -j] = temp;
                }
                // 위에서 swap한 char배열을 다시 String 으로 만들어 줌
                String s = new String(arr);
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
