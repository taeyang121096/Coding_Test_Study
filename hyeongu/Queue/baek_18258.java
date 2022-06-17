import java.util.*;

public class baek_18258 {
	
	static int N_Max = 2000000;
	static int first = 0;
	static int last = 0;
	static int [] queue = new int[N_Max];
	
	static StringBuilder print = new StringBuilder();
		
	public static void main(String[] args) {
		
		String command;
		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt(); 
		
		while(count>0) {
			command = scanner.next();
			
			switch(command) {
			case "push":push(scanner.nextInt()); break;
			case "pop":;pop(); break;
			case "size":size(); break;
			case "empty":empty(); break;
			case "front":front(); break;
			case "back":back(); break;
			}
			count--;
		}
		System.out.println(print);
	}
	
	static public void push(int value) {
		queue[last] = value;
		last++;
	}
	
	static public void pop() {
		if(last-first==0)
			print.append(-1).append('\n');
		else {
			print.append(queue[first]).append('\n');
			first++;
		}
	}
	
	static public void size() {
		print.append(last-first).append('\n');
	}
	
	static public void empty() {
		if(last-first==0)
			print.append(1).append('\n');
		else
			print.append(0).append('\n');
	}
	
	static public void front() {
		if(last-first==0)
			print.append(-1).append('\n');
		else
			print.append(queue[first]).append('\n');
	}
	
	static public void back() {
		if(last-first==0)
			print.append(-1).append('\n');
		else
			print.append(queue[last-1]).append('\n');
	}
}
