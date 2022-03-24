package BOJ;

import java.io.*;
import java.util.*;

public class FindPrime_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
        
        int[] m = new int[100];
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            m[i] = Integer.parseInt(st.nextToken());
            
            if (isPrime(m[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean isPrime(int num) {
    	if(num == 1) {
    		return false;
    	}
    	
    	// Math.sqrt(num)
    	// i*i <= num
    	
    	for(int i = 2; i*i <= num; i++) {
    		if(num % i == 0) {
    			return false;
    		}
    	}
    	
		return true;
    }
}