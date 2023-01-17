package SWEA.SSAFY;

import java.util.*;
import java.io.*;

public class LogCut {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tmp = Integer.parseInt(br.readLine());
            sb.append("#" + test_case + " ");
            if(tmp%2==1){
                sb.append("Bob").append("\n");
            }
            else{
                sb.append("Alice").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}