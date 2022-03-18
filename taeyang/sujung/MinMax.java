package Sujong;
import java.util.*;
import java.io.*;

public class MinMax {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
//        이렇게 정렬을 하면 오름 차순 정렬이 됨
//        7 10 20 30 35
        Collections.sort(list);
        System.out.println(list.get(0)+" "+list.get(n-1));
    }
}
