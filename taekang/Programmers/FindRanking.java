package Programmers;
import java.util.*;
public class FindRanking {

    class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            HashMap<String , Integer> hm = new HashMap<>();
            ArrayList<Integer>[][][][] al = new ArrayList[4][3][3][3];

            hm.put("-", 0);

            hm.put("cpp" , 1);
            hm.put("java" , 2);
            hm.put("python" , 3);

            hm.put("backend" , 1);
            hm.put("frontend" , 2);

            hm.put("junior" , 1);
            hm.put("senior" , 2);

            hm.put("chicken" , 1);
            hm.put("pizza" , 2);

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        for(int l = 0; l < 3; l++){
                            al[i][j][k][l] = new ArrayList<Integer>();
                        }
                    }
                }
            }

            for(String str : info){
                String[] tmp = str.split(" ");
                int lang = hm.get(tmp[0]);
                int end = hm.get(tmp[1]);
                int career = hm.get(tmp[2]);
                int food = hm.get(tmp[3]);
                int score = Integer.parseInt(tmp[4]);

                al[lang][end][career][food].add(score);

                al[0][end][career][food].add(score);
                al[lang][0][career][food].add(score);
                al[lang][end][0][food].add(score);
                al[lang][end][career][0].add(score);

                al[0][0][career][food].add(score);
                al[0][end][0][food].add(score);
                al[0][end][career][0].add(score);
                al[lang][0][0][food].add(score);
                al[lang][0][career][0].add(score);
                al[lang][end][0][0].add(score);

                al[0][0][0][food].add(score);
                al[0][0][career][0].add(score);
                al[0][end][0][0].add(score);
                al[lang][0][0][0].add(score);

                al[0][0][0][0].add(score);
            }

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        for(int l = 0; l < 3; l++){
                            Collections.sort(al[i][j][k][l], Collections.reverseOrder());
                        }
                    }
                }
            }

            for(int i = 0; i < query.length; i++){
                String[] str2 = query[i].split(" ");
                int lang2 = hm.get(str2[0]);
                int end2 = hm.get(str2[2]);
                int career2 = hm.get(str2[4]);
                int food2 = hm.get(str2[6]);
                int score2 = Integer.parseInt((str2[7]));

                ArrayList<Integer> al2 = al[lang2][end2][career2][food2];
                if(al2.size() > 0 && al2.get(0) >= score2){
                    answer[i] = count(al2, score2);
                } else {
                    answer[i] = 0;
                }
            }

            return answer;
        }

        static int count(ArrayList<Integer> list, int score){
            int cnt = 0;

            for(int i = 0; i < list.size(); i++){
                if(list.get(i) >= score){
                    cnt ++;
                } else {
                    break;
                }
            }
            return cnt;
        }
    }
}
