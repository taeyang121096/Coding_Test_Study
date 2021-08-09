import java.io.*;
import java.util.*;

public class baek_10866_deque {
	
	static ArrayDeque<Integer> deq = new ArrayDeque<>(10000);
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine()); 
		StringTokenizer command;
		
		while(count-- >0) {
			command = new StringTokenizer(br.readLine(), " ");
			
			switch(command.nextToken()) {
			case "push_back":
				deq.addLast(Integer.parseInt(command.nextToken()));
				break;
			case "push_front":
				deq.addFirst(Integer.parseInt(command.nextToken()));
				break;
			case "pop_front":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else {
					sb.append(deq.getFirst()).append('\n');
					deq.removeFirst();
				}
				break;
			case "pop_back":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else {
					sb.append(deq.getLast()).append('\n');
					deq.removeLast();
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
					sb.append(deq.getFirst()).append('\n'); 
			    break;
			
			case "back":
				if(deq.size()==0)
					sb.append(-1).append('\n');
				else
					sb.append(deq.getLast()).append('\n');
			    break;
			}
		}
		System.out.print(sb);
	}	
	
}


