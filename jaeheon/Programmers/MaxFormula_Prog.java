package Programmers;

//두개의 연산자가 동일한 우선순위를 가질 수 없음

//계산된 결과 음수 -> 절댓값
//expression 3 ~ 100

import java.util.*;

class MaxFormula_Prog {
	static char operator[][] = { { '+', '-', '*' }, { '+', '*', '-' }, { '-', '*', '+' }, { '-', '+', '*' },
			{ '*', '-', '+' }, { '*', '+', '-' } };

	static Long cal(char op, Long a, Long b) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	public long solution(String expression) {
		long answer = 0;
		ArrayList<Long> num = new ArrayList<>();
		ArrayList<Character> op = new ArrayList<>();

		String number = "";
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				number += expression.charAt(i);
			} else {
				num.add(Long.parseLong(number));
				op.add(expression.charAt(i));
				number = "";
			}
		}

		num.add(Long.parseLong(number));

//      for(int i = 0; i < num.size(); i++){
//          System.out.println(num.get(i));
//      }

//      for(int i = 0; i < op.size(); i++){
//          System.out.println(op.get(i));
//      }

		for (int i = 0; i < 6; i++) {
			ArrayList<Long> tmpNum = new ArrayList<>(num);
			ArrayList<Character> tmpOp = new ArrayList<>(op);

			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < tmpOp.size(); k++) {
					if (operator[i][j] == tmpOp.get(k)) {
						Long result = cal(operator[i][j], tmpNum.remove(k), tmpNum.remove(k));
						tmpNum.add(k, result);
						tmpOp.remove(k);
						k--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(tmpNum.get(0)));
		}

		return answer;
	}
}