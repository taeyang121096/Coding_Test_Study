package BOJ;

import java.util.*;
import java.io.*;

public class Lie_BOJ {

    static int n, m;
    static int answer;
    static boolean visit[];
    static List<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 사람수
        m = Integer.parseInt(st.nextToken()); // 파티수
        visit = new boolean[m]; // 파티 진실 여부
        party = new ArrayList[n+1]; // 사람별 파티참가
        for(int i = 1; i <= n; i++){
            party[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        answer = 0;
        int know = Integer.parseInt(st.nextToken()); // 진실 사람 수
        if(know == 0){
            System.out.println(m);
            System.exit(0);
        } else {
            int[] people = new int[know]; // 진실을 아는 사람
            for(int i = 0; i < know; i++){
                people[i] = Integer.parseInt(st.nextToken());
            }
            int[][] partyList = new int[m][]; // 파티 별 참가자
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int pNum = Integer.parseInt(st.nextToken()); // 파티별 참가자 수
                partyList[i] = new int[pNum];
                for(int j = 0; j < pNum; j++){
                    int tmp = Integer.parseInt(st.nextToken());
                    partyList[i][j] = tmp; // 파티에 참가하는 사람
                    party[tmp].add(i); // 사람별로 참가한 파티
                }
            }
            bfs(know, people, partyList);
            for(int i = 0; i < m; i++){
                if(!visit[i]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int know, int[] poeple, int[][] partyList){
        Queue<Integer> q = new LinkedList<>();
        boolean[] pVisit = new boolean[n+1];

        for(int i = 0; i < know; i++){
            q.add(poeple[i]);
        }
        while(!q.isEmpty()){
            int tmp = q.poll();
            pVisit[tmp] = true;
            for(int i = 0; i < party[tmp].size(); i++){
                int factKnowParty = party[tmp].get(i);
                visit[factKnowParty] = true;
                for(int j = 0; j < partyList[factKnowParty].length; j++){
                    if(pVisit[partyList[factKnowParty][j]]){
                        continue;
                    }
                    q.add(partyList[factKnowParty][j]);
                }
            }
        }
    }
}
