package Programmers;

//sklii -> 선행스킬순서
//skill tree -> 유저들이 만든 스킬트리
//스킬은 중복해서 주어지지 않음
//skill 안에 없는 스킬은 순서에 상관없이 배울 수 있음
//skill tree 중 가능한 개수 출력

import java.util.*;

class SkillTree_Prog {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			StringBuilder sb = new StringBuilder();
			String str = skill_trees[i];

			for (int j = 0; j < str.length(); j++) {
				if (skill.contains(String.valueOf(str.charAt(j)))) {
					sb.append(str.charAt(j));
				}
			}

			System.out.println(sb);

			for (int k = 0; k <= skill.length(); k++) {
				String tmp = skill.substring(0, k);

				if (tmp.equals(sb.toString())) {
					answer++;
					break;
				}
			}
		}

		return answer;
	}
}