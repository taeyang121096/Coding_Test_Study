// 기회는 3번이고 점수는 0점에서 10점
// 싱글s, 더블d, 트리플t 구역 존재
// 스타상* 해당, 전 점수 2배, 아차상# 해당점수 마이너스
// 옵션은 중첩 가능하지만 한번에는 하나만 존재가능

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int count = 0;
        int head = 0;
        int tmp;
        
        for(int i = 0; i<dartResult.length(); i++){
            switch(dartResult.charAt(i)){
                case 'S':
                    score[count++] = Integer.parseInt(dartResult.substring(head, i));
                    head = i+1;
                    break;
                case 'D':
                    tmp = Integer.parseInt(dartResult.substring(head, i));
                    score[count++] = tmp * tmp;
                    head = i+1;
                    break;
                case 'T':
                    tmp = Integer.parseInt(dartResult.substring(head, i));
                    score[count++] = tmp * tmp * tmp;
                    head = i+1;
                    break;
                case '*':
                    if(count>1){
                        score[count-2] *=2;
                    }
                    score[count-1] *=2;
                    head = i+1;
                    break;
                case '#':
                    score[count-1] *= -1;
                    head = i+1;
                    break;
            }
        }
        for(int i : score){
            answer += i;
        }
        return answer;
    }
}