package basic;

import java.util.*;
import java.io.*;
public class Cusor {

    static LinkedList<Character> list = new LinkedList<>();
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = str.length();
        int m = Integer.parseInt(br.readLine());
        for(char c: str.toCharArray())
            list.add(c);
        for(int i = 0;i<m;i++){
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("L")){
                if(index >0)
                    index--;
            }
            else if(cmd[0].equals("D")){
                if(index < list.size())
                    index++;
            }
            else if(cmd[0].equals("B")){
                if(index>0){
                    list.remove(index-1);
                    index--;
                }
            }
            else if(cmd[0].equals("P")){
                if(index == 0){
                    list.add(0,cmd[1].charAt(0));
                    index++;
                }else {
                    list.add(index,cmd[1].charAt(0));
                    index++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(char c : list){
            bw.write(c);
        }
        bw.flush();
        bw.close();

    }
}
