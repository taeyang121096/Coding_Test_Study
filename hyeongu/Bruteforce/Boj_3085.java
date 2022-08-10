import java.io.*;
import java.util.*;

public class Boj_3085 {
	public static char[][] arr;
	public static int max = 1;
	public static int N;
	
	
    public static void swap(int x1, int y1, int x2, int y2) {
    	char tmp = arr[x1][y1];
    	arr[x1][y1] = arr[x2][y2];
    	arr[x2][y2] = tmp;
    }
    
    public static int checkRow(int x) {
    	char tmp = arr[x][0];
    	int count = 1;
    	int result = 1;
    	for(int i = 1; i<N; i++) {
    		if(tmp == arr[x][i]) {
    			count++;
    		}
    		else {
    			tmp = arr[x][i];
    			result = Math.max(result, count);
    			count = 1;
    		}
    	}
    	result = Math.max(result, count);
    	return result;
    }
    
    public static int checkCol(int y) {
    	char tmp = arr[0][y];
    	int count = 1;
    	int result = 1;
    	for(int i = 1; i<N; i++) {
    		if(tmp == arr[i][y]) {
    			count++;
    		}
    		else {
    			tmp = arr[i][y];
    			result = Math.max(result, count);
    			count = 1;
    		}
    	}
    	result = Math.max(result, count);
    	return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        
        for(int i = 0; i<N; i++) {
        	String str = br.readLine();
        	for(int j = 0; j<N; j++) {
        		arr[i][j] = str.charAt(j);
        	}
        }
        for(int i = 0; i<N; i++) {
        	max = Math.max(max, checkRow(i));
        }
        for(int i = 0; i<N; i++) {
        	max = Math.max(max, checkCol(i));
    	}
        
        for(int i = 0; i<N; i++) {
        	for(int j = 0; j<N-1; j++) {
        		swap(i, j, i, j+1);
        		int a = checkRow(i);
        		int b = checkCol(j);
        		int c = checkCol(j+1);
        		max = Math.max(Math.max(a, b), Math.max(c, max));
        		swap(i, j, i, j+1);
        	}
        }
        for(int i = 0; i<N-1; i++) {
        	for(int j = 0; j<N; j++) {
        		swap(i, j, i+1, j);
        		int a = checkCol(j);
        		int b = checkRow(i);
        		int c = checkRow(i+1);
        		max = Math.max(Math.max(a, b), Math.max(c, max));
        		swap(i, j, i+1, j);
        	}
        }
        System.out.println(max);
    }
}