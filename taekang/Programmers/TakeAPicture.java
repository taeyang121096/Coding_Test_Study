//package Programmers;
//
//import java.util.*;
//
//public class TakeAPicture {
//    static List<String> list = new ArrayList<>();
//    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
//    static StringBuilder sb = new StringBuilder();
//    static int answer = 0;
//    public static void main(String[] args) {
//        int n = 2;
//        String[] data = {"N~F=0", "R~T>2"};
//        // 네오는 프로도와 나란히 서길 바람
//        // 라이언은 튜브에게서 적어도 세칸 이상 떨어져
//        // 모든 조건을 만족할 수 있도록 서는 경우의 수
//
//        // 조건의 개수 : n, n개의 원소로 구성된 문자열 배열 data
//        // 만약 NF가 붙어있다면 나머지 6자리에서
//        boolean[] visited = new boolean[8];
//        find("", visited, data);
//
//        System.out.println(answer);
//    }
//
//    public void find(String names, boolean[] visited, String[] data) {
//        //  종료 조건
//        if(names.length() == 8){
//            if (check(names, data)) { // 조건만족 체크
//                answer++;
//            }
//            return;
//        }
//
//        for (int i = 0; i < 8; i++) { // 조합
//            if (!visited[i]) {
//                visited[i] = true;
//                String name = names + friends[i];
//                find(name, visited, data);
//                visited[i] = false;
//            }
//        }
//    }
//    private boolean check(String names, String[] datas) {
//        for (String data : datas) {
//            int first_idx = names.indexOf(data.charAt(0));
//            int second_idx = names.indexOf(data.charAt(2));
//            char operation = data.charAt(3);
//            int value = data.charAt(4) - '0'; // 이게 관건이었는데 이유는 자세히 알아보자..
//
//            if (operation == '=') {
//                if (!(Math.abs(first_idx - second_idx) == value+1))
//                    return false;
//            } else if (operation == '>') {
//                if (!(Math.abs(first_idx - second_idx) > value+1))
//                    return false;
//            } else if (operation == '<') {
//                if (!(Math.abs(first_idx - second_idx) < value+1))
//                    return false;
//            }
//        }
//
//        return true;
//    }
//}
