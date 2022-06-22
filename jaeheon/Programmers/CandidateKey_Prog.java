package Programmers;

//후보키 -> 유일성과 최소성 동시 만족
//예제에서 이름 전공을 동시에 사용하면 릴레이션 모든 튜플 식별 가능
//relation 2차원 문자열 배열
//후보키의 개수를 출력
//컬럼은 최대 8개
//row 20개

//후보키가 가능한 모든 조합 구함
//유일성을 통과한 애들만 저장
//새로운 후보키 찾을때마다 -> 최소성 체크함

import java.util.*;

public class CandidateKey_Prog {
	static ArrayList<String> al = new ArrayList<>();
    static ArrayList<Integer> al2;
    
    static void find(int start, int depth, int end, boolean[] visit, String[][] relation){
        if(depth == end){
            al2 = new ArrayList<>();
            String key = "";
            for(int i = 0; i < visit.length; i++){
                if(visit[i]){
                    key+=String.valueOf(i);
                    al2.add(i);
                }
            }
            
            HashMap<String, Integer> hm = new HashMap<>();
            for(int i = 0; i < relation.length; i++){
                String str = "";
                for(int j : al2){
                    str += relation[i][j];
                }
                if(hm.containsKey(str)){
                    return;
                } else {
                    hm.put(str, 0);
                }
            }
            
            for(String tmp : al){
                int cnt = 0;
                for(int i = 0; i < key.length(); i++){
                    String tmpKey = String.valueOf(key.charAt(i));
                    if(tmp.contains(tmpKey)){ // 최소성 체크
                        cnt++;
                    }
                } 
                if(cnt == tmp.length()){
                    return;
                }
            }
            al.add(key);
        }
        
        for(int i = start; i < visit.length; i++){
            if(!visit[i]){
                visit[i] = true;
                find(i, depth + 1, end, visit, relation);
                visit[i] = false;
            }
        }
    }
    
    public int solution(String[][] relation) {
        int answer = 0;
        boolean[] visit;
        
        for(int i = 0; i < relation[0].length; i++){
            visit = new boolean[relation[0].length];
            find(0, 0, i+1, visit, relation);
        }
        
        answer = al.size();
        
        return answer;
    }
}
