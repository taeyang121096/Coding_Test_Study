package Programmers;

import java.util.*;


public class MenuRenual {
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static void put(char[] charArr, boolean[] visited, int n) {
        sb.setLength(0);
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(charArr[i]);
            }
        }
        char[] set = sb.toString().toCharArray();
        Arrays.sort(set);

        String str = new String(set);

        if(!map.containsKey(str)) {
            map.put(str, 1);
        } else {
            int num = map.get(str);
            map.put(str, num+=1);
        }
    }

    static void dfs(char[] charArr, boolean[] visited, int start, int n, int r) {
        // 종료조건
        if (r == 0) {
            put(charArr, visited, n);
            return;
        }
        for(int i = start; i < n; i++){ // 여기서 왜 0부터 시작하면 안되는거지 ???????
            visited[i] = true;
            dfs(charArr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        List<String> list = new ArrayList<>();
        for(int i = 0; i < orders.length; i++){  // 6회 반복
            char[] charArr = orders[i].toCharArray(); // orders[i]를 char 배열로 선언
            boolean[] check = new boolean[orders[i].length() + 1];

            for(int j = 0; j < course.length; j++){ // 2 3 4 반복
                if(charArr.length >= course[j]){
                    dfs(charArr, check, 0, charArr.length, course[j]); // dfs("ABCFG", 5, 2, 0, 0)
                }
            }
        }

        for(int i = 0; i < course.length; i++) {
            int max = 0;
            for(String key : map.keySet()) {
                if(key.length()==course[i]) {
                    int num = map.get(key);
                    if(num>max && num > 1) {
                        max = num;
                    }
                }
            }

            for(String key : map.keySet()) {
                if(key.length()==course[i]) {
                    int num = map.get(key);
                    if(num==max) {
                        list.add(key);
                    }
                }
            }
        }

        Collections.sort(list);

        String[] answer = list.toArray(new String[list.size()]);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
