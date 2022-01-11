package Programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Number4 {
    public static void main(String[] args) {

        int[] answers = {1, 2, 3, 4, 5};

        int[] step1 = {1, 2, 3, 4, 5};
        int[] step2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] step3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score ={0,0,0};

        for (int i = 0 ; i < answers.length; i++) {
            if (answers[i] == step1[(i) % step1.length]) {
                score[0]++;
            }
            if (answers[i] == step2[(i) % step2.length]) {
                score[1]++;
            }
            if (answers[i] == step3[(i) % step3.length]) {
                score[2]++;
            }
        }

        int max = -9999;
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }

        ArrayList<Integer> lists = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                lists.add(i + 1);
            }
        }

        int answer[] = new int[lists.size()];

        for (int i = 0; i < lists.size(); i++) {
            answer[i] = lists.get(i);
        }
    }
}

