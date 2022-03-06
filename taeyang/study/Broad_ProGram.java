import java.util.*;

public class Broad_ProGram {


    //
//     U : x칸 위에 있는 행
//     D : x칸 아래 있는 행
//     C : 현재 선택 행 삭제 및 아래 행 선택, 삭제 행이 가장 마지막인 경우 위 행 선택
//     Z : 가장 최근 삭제 행 원래 복구 단 선택 행 바뀌지 않음
//
    static Stack<Integer> stack = new Stack<>();
    static int size;

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        size = n;
        Stack<Integer> stack = new Stack<>();
        for (String str : cmd) {
            String[] tmp = str.split(" ");
            if (tmp[0].equals("U")) {
                k -= Integer.parseInt(tmp[1]);
            } else if (tmp[0].equals("D")) {
                k += Integer.parseInt(tmp[1]);
            } else if (tmp[0].equals("C")) {
                stack.push(k);
                size--;
                if (size == k)
                    k--;
            } else {
                int val = stack.pop();
                if (k >= val)
                    k += 1;
                size++;
            }
        }
        while (size != 0) {
            sb.append("O");
            size--;
        }
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }
}

