package Programmers;

import java.lang.*;
import java.util.Arrays;

public class Number3 {
    public static void main(String[] args) {
        int temp;
        int[] numbers = {6, 10, 2};
        String s = Arrays.toString(numbers);
        String array[]=s.substring(1, s.length()-1).split(", ");
        int count = 0;
        String[] step1 = new String[numbers.length - 1];
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {
                if (j != i) {
                    step1[count] = array[j];
                    count++;
                }
            }
            count = 0;

        }

    }
}
