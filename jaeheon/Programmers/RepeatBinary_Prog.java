package Programmers;

//1이 될때까지 이진변환
//정답 [이진변환을 가한 횟수, 없어진 0의 개수]

public class RepeatBinary_Prog {
	public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        while(!s.equals("1")){
            cnt1++; // 이진변환 횟수
            String str = s.replace("0", "");
            cnt2 += s.length() - str.length(); // 제거된 0의 수
            s = Integer.toString(str.length(), 2);
        }

        answer[0] = cnt1;
        answer[1] = cnt2;
        
        return answer;
    }
}
