import java.util.*;
import java.io.*;
 
public class baek_1182 {
	static int N;
	static int S;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] number = new int[N];
 
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        choose(number, 0, 0);
        if(S==0)
        	System.out.println(--answer);
        else
        	System.out.println(answer);
    }
 
    static void choose(int[] arr, int index, int count){

    	if(index==N) {        	
    		if(count == S)
        		answer++;
    		return;
    	}
    	choose(arr, index+1, count+arr[index]);
    	choose(arr, index+1, count);
    }
}
