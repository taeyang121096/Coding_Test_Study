package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Number2 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int answer[] = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> lists = new ArrayList<>();
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                lists.add(array[j]);
            }
            Collections.sort(lists);
            answer[i] = commands[i][2]-1;
        }
    }
}
