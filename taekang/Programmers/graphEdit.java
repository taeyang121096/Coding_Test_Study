package Programmers;
import javax.swing.*;
import java.util.*;

public class graphEdit {
    static int start; // 시작 2
    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        start = k; // 시작 위치, 2
        LinkedList<String> list = new LinkedList<>(); // {0, "O"}
        Stack<Integer> stack = new Stack<>(); // c한 거 저장

        for(int i = 0; i < n; i++){
            list.add(i, "O");
        }

        for(int i = 0; i < cmd.length; i++) {
            if (cmd[i].length() == 3) {
                String[] str = cmd[i].split(" ");
                String s = str[0]; // D
                Integer s2 = Integer.parseInt(str[1]); // 2

                if (s.equals("D")) {
                    start += s2;
                } else if (s.equals("U")) {
                    start -= s2;
                }

            } else {
                String s = cmd[i];

                if (s.equals("C")) {
                    if (list.size() == start) {
                        list.remove(start);
                        stack.push(start);
                        start -= 1;
                    } else {
                        list.remove(start); // start 위치에 있는 거 삭제,
                        stack.push(start); // 삭제 된거 어디다 저장하지 ?, stack에 첫번째에 해당 index를 저장하자.
                        // start위치 바꿔줄 필요가 없지 ?
                    }
                } else if (s.equals("Z")) {
                    int restart = stack.pop(); // 가장 최근??복구니까 stack에서 index뽑아옴
                    list.add(restart, "X");
                    start += 1;
                }
            }
        }
       // stack 에 저장돼있는 4...위치에만 X
        String answer = "";

        System.out.println(answer);
    }
}
