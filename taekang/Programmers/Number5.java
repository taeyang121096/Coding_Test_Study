package Programmers;

public class Number5 {
    public static void main(String[] args) {

        int number = 5;
        int[] lost = {2,4};
        int[] reserve = {1,2, 5};

        // 체육복 가지고있는 숫자만큼 배열 정리 했음.
        Number5 number5 = new Number5();
        int[] n = number5.insert(number, lost, reserve);

        int answer = 0;

        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }

    public int[] insert(int number, int[] lost, int[] reserve) {
        int[] n = new int[number];

        for (int i = 0; i < n.length; i++) {
            n[i] = 1;
        }

        for (int i = 0; i < lost.length; i++) {
            n[lost[i] - 1] = 0;
        }

        for (int i = 0; i < reserve.length; i++) {
            if (n[reserve[i] - 1] == 1) {
                n[reserve[i] - 1] = 2;
            } else {
                n[reserve[i] - 1] = 1;
            }
        }

        return n;
    }
}
