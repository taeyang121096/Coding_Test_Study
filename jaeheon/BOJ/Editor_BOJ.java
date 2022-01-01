import java.util.*;

public class Editor_BOJ {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();

        String word = sc.nextLine();
        int n = sc.nextInt(); // command의 개수
        int cursor = word.length(); // 커서의 위치는 단어의 길이
        int length = word.length(); 

        // 스택에 문자열 추가
        for (int i = 0; i < length; i++){
            stack.push(word.substring(i, i+1)); // split으로 못하는지 궁금
        }
        // 커맨드 받기.
        for (int i = 0; i < n; i++){
            String command = sc.next();
            
            // 왼쪽으로 이동
            if (command.equals("L")){
                if (cursor == 0){ // 커서가 제일 왼쪽에 위치
                    continue;
                }
                else{
                    cursor -= 1;
                }
            }
            
            // 오른쪽으로 이동
            if (command.equals("D")){
                if (cursor == length){ // 커서가 가장 오른쪽에 위치
                    continue;
                }
                else{
                    cursor += 1;
                }
            }
            
            // 커서 왼쪽에 있는것 삭제
            if (command.equals("B")){
                if (cursor == 0){ // 커서가 왼쪽에 박혀있음
                    continue;
                }
                else{
                	stack.set(cursor - 1, "");  // set은 인덱스로 스택 값 변경 가능, remove도 사용 가능
                    cursor -= 1; // 왼쪽으로 하나를 삭제했으니까 커서도 왼쪽으로 이동
                    length -= 1; // 왼쪽으로 하나를 삭제했으니까 길이 -1
                }
            }
            
            if (command.equals("P")){
                String p = sc.next();
                stack.add(cursor,p);
                cursor += 1;
                length += 1;
            }
        }
        // 결과 출력
        for (int i = 0; i < length; i++){ // 스택 인덱스의 값 확인
            System.out.print(stack.elementAt(i));
        }
    }
}
