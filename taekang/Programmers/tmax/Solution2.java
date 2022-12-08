package Programmers.tmax;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int[] balance = {30, 30, 30, 30};
        int[][] transaction = {{1, 2, 10}, {2, 3, 20}, {3, 4, 5}, {3, 4, 30}};
        int[] abnormal = {2, 3};
        int[] answer = new int[balance.length];

        ArrayList<Deque<int[]>> list = new ArrayList<>();
        for (int i = 0; i < balance.length; i++) {
            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{i + 1, balance[i]});
            list.add(stack);
        }

        for (int i = 0; i < transaction.length; i++) {
            int from = transaction[i][0] - 1; // 1
            int to = transaction[i][1] - 1; // 2
            int val = transaction[i][2]; // 20

            Deque<int[]> from_stack = list.get(from); // list.get(1)
            Deque<int[]> to_stack = list.get(to); // list.get(2)

            while (!from_stack.isEmpty()) {
                int[] from_arr = from_stack.pollLast(); // {1,10}
                if (from_arr[1] >= val) { //
                    from_stack.offerLast(new int[]{from_arr[0], from_arr[1] - val});
                    to_stack.offerLast(new int[]{from_arr[0], val});
                    break;
                } else { // 10 < 20
                    val -= from_arr[1]; // 20 - 10 = 10
                    to_stack.offerLast(new int[]{from_arr[0], from_arr[1]}); // 1, 10
                }
            }
        }

        int[] abn_val_arr = new int[balance.length]; // 0 20 15 25

        for (int i = 0; i < abnormal.length; i++) { // 2 3
            int abn = abnormal[i];
            int abn_val = 0;

            for (int j = 0; j < list.size(); j++) {
                Deque<int[]> stack = list.get(j);
                int idx = 0;
                boolean flag = false;

                while (idx != stack.size()) {
                    int[] poll = stack.poll(); //
                    if (poll[0] == abn) {
                        flag = true;
                        abn_val += poll[1];
                    }
                    idx++;
                    stack.offerLast(poll);
                }
                abn_val_arr[j] += abn_val;
                abn_val = 0;
            }
        }

//        for (int i = 0; i < abn_val_arr.length; i++) {
//            System.out.println(abn_val_arr[i]);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            Deque<int[]> stack = list.get(i);
//            while (!stack.isEmpty()) {
//                int[] pop = stack.pollFirst();
//                System.out.print("(" + pop[0] + " " + pop[1] + ")");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < list.size(); i++) {
            Deque<int[]> stack = list.get(i);
            int sum = 0;
            while (!stack.isEmpty()) {
                int[] pop = stack.pollFirst();
                sum += pop[1];
            }
            answer[i] = sum - abn_val_arr[i];
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(answer[i]);
        }
    }
}