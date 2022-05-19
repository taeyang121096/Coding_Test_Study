package com.taeyang_toy.springtoy;
import java.util.*;
public class Doll {

    class Solution {
        /*
            board = 5 ~ 30 len
            0 -> empty 1 ~ 100
            moves -> 1 ~ 1000

            2개 이상 쌓이면 -> 없어진다.

            data-structre : stack

            1. 인형이 없는 경우에는 아무런 일이 안일어난다.

            stack에 인형을 쌓고 들어오는 것과 비교해서 pop을 해준다

            1. moves -> 순회 한다 idx -1 -> 위치 -> col
            2. board -> row를 순회 하며 -> 제일 위 dat를 빼주고  0으로 치환
            3. data -> stack peek 비교 후 push or pop
            4. pop 할경우 -> ans +2

        */
        Stack<Integer> stack = new Stack<>();
        int ans=0;

        void check(int val){
            if(stack.isEmpty()){
                stack.push(val);
            }else{
                if(stack.peek() == val){
                    stack.pop();
                    ans += 2;
                }else{
                    stack.push(val);
                }
            }
        }

        public int solution(int[][] board, int[] moves) {
            int row = board[0].length;

            for(int m : moves){
//             1.
                int idx = m-1;

                for(int r = 0;r<row;r++){
                    if(board[r][idx] != 0){
                        check(board[r][idx]);
                        board[r][idx] = 0;
                        break;
                    }
                }

            }

            return ans;
        }
    }
}
