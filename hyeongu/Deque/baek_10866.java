import java.io.*;
import java.util.*;

public class baek_10866 {
	
	static ArrayList<Integer> deq = new ArrayList<>(10000);
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine()); 
		StringTokenizer command;
		
		while(count-- >0) {
			command = new StringTokenizer(br.readLine(), " ");
			
			switch(command.nextToken()) {
			case "push_back":
				deq.add(Integer.parseInt(command.nextToken()));
				break;
			case "push_front":
				deq.add(0,Integer.parseInt(command.nextToken()));
				break;
			case "pop_front":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else {
					sb.append(deq.get(0)).append('\n');
					deq.remove(0);
				}
				break;
			case "pop_back":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else {
					sb.append(deq.get(deq.size()-1)).append('\n');
					deq.remove(deq.size()-1);
				}
				break;
			case "size":
				sb.append(deq.size()).append('\n'); 
				break;
			case "empty":
				if(deq.size() ==0)
					sb.append(1).append('\n');
				else 
					sb.append(0).append('\n');
				break;
			
			case "front":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else
					sb.append(deq.get(0)).append('\n'); 
			    break;
			
			case "back":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else
					sb.append(deq.get(deq.size()-1)).append('\n');
			    break;
			}
		}
		System.out.print(sb);
	}	
	
}


