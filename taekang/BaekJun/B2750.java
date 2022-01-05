package BaekJun;

import java.util.*;

public class B2750 {

    int number, i, j, temp, index;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        B2750 b2750 = new B2750();
        int[] result = b2750.insert();
        int[] sort = b2750.sort(result);
        for (int array : sort) {
            System.out.println(array);
        }
    }

    public int[] insert() {
        number = scanner.nextInt();
        int[] a = new int[number];
        for (i = 0; i < number; i++) {
            int array = scanner.nextInt();
            a[i] = array;
        }
        return a;
    }

    public int[] sort(int[] a) {
        for (i = 0; i < a.length; i++) {
            int min = 1001;
            for (j = i; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    index = j;
                }
            }
            temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }

        return a;
    }
}
