package basic;

import java.io.*;
import java.util.*;
public class Confere {

    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new int[]{s,e});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]>o2[0] ? 1:-1;
                }
                return o1[1]>o2[1] ? 1:-1;
            }
        });
        int e =0;
        int count = 0;
        for(int[] tmp : list){
            if(tmp[0]>=e){
                e = tmp[1];
                count++;
            }
        }
        System.out.println(count);
    }
}
