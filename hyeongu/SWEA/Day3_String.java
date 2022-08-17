import java.io.*;
public class Day3_String {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i<=10; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int count = 0;
        	String word = br.readLine();
        	String str = br.readLine();
        	
        	for(int j = 0; j<str.length() - word.length() + 1; j++) {
        		if(word.charAt(0) == str.charAt(j)) {
        			for(int k = 1; k<word.length(); k++) {
        				if(word.charAt(k) != str.charAt(j + k)) {
        					break;
        				}
        				if(k == word.length() - 1) {
        					count++;
        				}
        			}
        		}
        	}
        	sb.append("#").append(i).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
	}
}
