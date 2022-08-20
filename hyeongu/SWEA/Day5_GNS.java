import java.io.*;
import java.util.*;
public class Day5_GNS {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        String[] arr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        for(int T = 1; T<=10; T++) {
        	int[] answer = new int[10];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String trash = st.nextToken();
        	int N = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<N; i++) {
        		int tmp = Arrays.asList(arr).indexOf(st.nextToken());
        		answer[tmp]++;
        	}
        	sb.append("#").append(T).append("\n");
        	for(int i = 0; i<10; i++) {
        		for(int j = 0; j<answer[i];j++) {
        			sb.append(arr[i] + " ");
        		}
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}
}
