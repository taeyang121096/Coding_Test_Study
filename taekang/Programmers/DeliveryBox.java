//import java.util.*;
//
//class Solution {
//    public int solution(int[] order) {
//        int answer = 0;
//        int N = order.length; // 5
//        Deque<Integer> deque = new ArrayDeque<>(); // 1 2 3 4 5
//        for (int i = 1; i <= N; i++) {
//            deque.offer(i);
//        }
//        Stack<Integer> stack = new Stack<>();
//        //
//        //
//        // 5
//        boolean flag = true;
//        for (int i = 0; i < order.length; i++) { // 1
//            while (true) {
//                if (deque.size() > 0) {
//                    if (stack.size() == 0) {
//                        int a = deque.poll();
//                        if (a != order[i]) { // 1
//                            stack.push(a); // a
//                        } else {
//                            answer++;
//                            break;
//                        }
//                    } else if (stack.size() != 0) {
//                        int a = deque.peek(); // 5
//                        int b = stack.peek(); // 4
//                        if (a == order[i]) {
//                            answer++;
//                            deque.poll();
//                            break;
//                        } else if (b == order[i]) {
//                            answer++;
//                            stack.pop();
//                            break;
//                        } else if (a != order[i] && b != order[i] && deque.size() > 1) {
//                            stack.push(a);
//                            deque.poll();
//                        } else if (a != order[i] && b != order[i] && deque.size() == 1) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                } else if (deque.size() <= 0) {
//                    if (stack.size() > 0) {
//                        int b = stack.peek();
//                        if (b == order[i]) {
//                            answer++;
//                            stack.pop();
//                        }
//                    } else {
//                        flag = false;
//                        break;
//                    }
//
//                }
//            }
//            if (!flag) {
//                break;
//            }
//        }
//
//        return answer;
//    }
//}