package Sujong;

import java.util.*;

public class Best {

    class Solution {
        //
//     1. 속한 노래가 많이 재생 장르
//     2. 장르 내에서 많이 재생 노래 먼저 수록
//     3. 장르 내에서 횟수 같으면 고유 번호 낮은 거 수록
//
//     1. 장르, 카운트 -> map
//     2. 장르,(idx,cnt) -> map
//     3. list 만들어서 순서대로 넣어주면 되겠지 ?.?
//
//
        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> map = new HashMap<>();
            Map<String, List<int[]>> genre = new HashMap<>();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < genres.length; i++) {
                if (map.containsKey(genres[i])) {
                    map.put(genres[i], map.get(genres[i]) + plays[i]);
                    genre.get(genres[i]).add(new int[]{i, plays[i]});
                } else {
                    map.put(genres[i], plays[i]);
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, plays[i]});
                    genre.put(genres[i], list);
                }
            }

            List<Map.Entry<String, Integer>> ls = new ArrayList<>(map.entrySet());

            Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                    return m1.getValue() > m2.getValue() ? -1 : 1;
                }
            });
            for (Map.Entry<String, Integer> en : ls) {
                int cnt = 0;
                Collections.sort(genre.get(en.getKey()), new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] == o2[1])
                            return o1[0] > o2[0] ? 1 : -1;
                        return o1[1] > o2[1] ? -1 : 1;
                    }
                });
                for (int[] tmp : genre.get(en.getKey())) {
                    if (cnt == 2)
                        break;
                    ans.add(tmp[0]);
                    cnt++;
                }
            }
            int[] answer = new int[ans.size()];
            int idx = 0;
            for (int i : ans) {
                answer[idx++] = i;
            }

            return answer;
        }
    }
}
