import java.util.*;
import java.io.*;

public class Test1 {
   public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();

        String input = scan.readLine();
        
       for(int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}

        int number = Integer.parseInt(scan.readLine());
        int cursor = input.length();

        for (int i = 0; i < number; i++) {
            String str = scan.readLine();

            char commend = str.charAt(0);

            if (commend=='P') {
                list.add(cursor, str.charAt(2));
                cursor = cursor + 1;
            } else if (commend=='L') {
                if (cursor > 0) {
                    cursor --;
                }
            } else if (commend=='D') {
                if (cursor < list.size()) {
                    cursor ++;
                }
            } else {
                if(cursor > 0) {
                    list.remove(cursor - 1);
                    cursor = cursor - 1;
                }
            }
        }
        
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i));
        }

        System.out.println(bw.toString());
    }
}
