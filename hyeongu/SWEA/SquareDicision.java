package SWEA.SSAFY;

import java.util.*;
import java.io.*;

public class SquareDicision {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;
            List<int[]> al = new ArrayList<>();

            for(int i = 0; i<N; i++){
                String str = br.readLine();
                for(int j = 0; j<N; j++){
                    if(str.charAt(j) == '#'){
                        al.add(new int[] {i, j});
                    }
                }
            }

            int[] first = al.get(0);
            int[] last = al.get(al.size()-1);


            if((last[1] - first[1]) != (last[0] - first[0]) || (last[1] - first[1] + 1) * (last[0] - first[0] + 1) != al.size()){
                sb.append("#" + test_case + " ").append("no\n");
                continue;
            }

            for(int[] arr : al){
                if(arr[0] < first[0] || arr[0] > last[0] || arr[1] < first[1] || arr[1] > last[1]){
                    flag = false;
                    break;
                }
            }
            if(flag) sb.append("#" + test_case + " ").append("yes\n");
            else sb.append("#" + test_case + " ").append("no\n");
        }
        System.out.println(sb.toString());
    }
}