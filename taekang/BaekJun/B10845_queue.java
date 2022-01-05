package BaekJun;

import java.io.*;
import java.util.*;

public class B10845_queue{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 자바에서는 Queue를 LinkedList를 통해 구현한다.
         * - 배열을 통해 구현하지 않는 이유 : 크기를 미리 지정해야 함, 크기가 고정되어있기 때문에 공간할당에 문제가 발생함
         * - ArrayList가 아닌 LinkedList를 통해 구현하는 이유 : ArrayList는 배열 기반의 자료구조임,
         * ArrayList와 같은 배열 기반의 자료구조를 사용하게 되면 빈공간을 채우기 위해서 데이터의 복사가 발생하므로 매우 비효율적임
         * 그래서 Queue는 ArrayList보다 데이터의 추가/삭제가 쉬운 LinkedList로 구현하는 것이 적합
         *
         * - 자바에서 제공하는 Queue class
         * queue 추가 : add(index), offer(index)
         * queue 삭제 : poll() - 첫 번째 값 반환하고 제거, remove() - 첫 번째 값 제, clear() - queue 초기화
         * queue 값 반환 : peek()
         * queue size : size()
         */

        // back을 구현하기 위해 push 될 때마다 마지막에 push 된 값을 last라는 변수에 저장해놓음.
        int last = -1;

        int T = Integer.parseInt(br.readLine());
        //scan.nextLine();

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            // push
            if (input.contains("push")) {
                String[] arr = input.split(" ");
                int value = Integer.parseInt(arr[1]);
                queue.add(value);
                // push가 선언될 때 마다 last에 push되는 값을 저장해주면 항상 queue의 마지막 요소의 값이 들어가있게 됨
                // 이 last 값은 back에서 출력해주면 됨
                last = value;
            } else if (input.equals("front")){
                if (queue.isEmpty())
                    //System.out.println(-1);
                    bw.write("-1" + "\n");
                else
                    //System.out.println(queue.peek());
                    bw.write(queue.peek() + "\n");
            } else if (input.equals("back")) {
                if (queue.isEmpty())
                   // System.out.println(-1);
                    bw.write("-1" + "\n");
                else
                    //System.out.println(last);
                    bw.write(last + "\n");
            } else if (input.equals("size")) {
                //System.out.println(queue.size());
                bw.write(queue.size() + "\n");
            } else if (input.equals("empty")) {
                if (queue.isEmpty())
                    //System.out.println(1);
                    bw.write("1" + "\n");
                else
                    //System.out.println(0);
                    bw.write("0" + "\n");
            } else if (input.equals("pop")) {
                if (queue.isEmpty())
                    //System.out.println(-1);
                    bw.write("-1" + "\n");
                else
                    //System.out.println(queue.poll());
                    bw.write(queue.poll() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
