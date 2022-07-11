package Programmers;

//board 배열 : 5by5 ~ 20by20
//0은 빈칸
//인형의 종류 1 ~ 100
//move : 1 ~ 1000 -> 크레인의 위치
//move 배열의 각 원소들의 값 1 ~ board 가로크기 이하
//move가 끝난 후 터뜨린 인형의 개수 return
//배열의 요소가 0이 아님 -> 스택이 비어있지 않고 peek한거랑 현재 뽑은거랑 같음 -> answer+=2, stack.pop
//배열의 요소가 0이 아님 -> 스택안의 결과와 같지 않거나 스택이 비어있음 -> 스택에 추가하고 
//배열 0으로 바꿈

import java.util.*;

public class Crain_Prog {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] > 0) {
					if (!stack.isEmpty() && stack.peek() == board[j][moves[i] - 1]) {
						answer += 2;
						stack.pop();
					} else {
						stack.push(board[j][moves[i] - 1]);
					}
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}

		return answer;
	}
}
