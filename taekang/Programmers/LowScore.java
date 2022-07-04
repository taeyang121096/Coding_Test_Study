package Programmers;

public class LowScore {
    static int answer = 0;
    public static void main(String[] args) {
        int[] grade = {3,2,3,6,4,5};
        recur(grade, -1);
        System.out.println(answer);
    }

    static public void recur(int[] grade, int idx){
        // 1. 변수 생성
        // 2. 탈출 조건
        if(idx == grade.length - 1){
            return;
        } else { // 3. 연산
            int min = Integer.MAX_VALUE;
            // int idx = -1
            int min_idx = -1;
            for(int i = idx + 1; i < grade.length; i++){
                if(min > grade[i]){
                    min = grade[i];
                    min_idx = i;
                }
            }
            // idx = -1, min_idx = 1
            for(int i = idx + 1; i < min_idx; i++){
                int dis = grade[i] - grade[min_idx];
                answer += dis;
            }

            recur(grade, min_idx);
        }
    }
}
