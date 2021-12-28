package basic;
import java.util.*;
public class PostPre {

    public static void main(String[]args){
        Deque<Character> stack = new ArrayDeque<>();
//        일단 스택을 만들고
        HashMap<Character,Integer> map = new HashMap<>();
//        이게 우선순위 !! 클수록 우선순위가 높게 괄호는 일단 넣어 줫어 뭘 만나든 들어가게 ㅇㅇㅇ
        map.put('+',0);
        map.put('-',0);
        map.put('*',1);
        map.put('/',1);
        map.put('(',-1);
//        ㅇㅇ 이게 다였는데 어렵긴 했음
//        그 면접 있잔항
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String ans = "";
//        그리고 이건 뭔지 알지
        int start = 'A';
        int end = 'Z';
        for(char c : exp.toCharArray()){
//            여기서 알파벳 사이에 있는지 없는지 체크
            if(c<start || c>end){
//                이제 스택이 첨에 비어있음 걍 넣어주고
                if(stack.isEmpty()){
                    stack.push(c);
                }
//                아닌 경우에는 만약 닫는 괄호가 나오잖아?
                else{
                    if(c==')'){
//                        여는 괄호 나올 때까지 뽑아주고 붙여 준느겨
                        while(stack.peek() != '('){
                            ans+= stack.pop();
                        }
//                        그리고 ㅇㅇㅇ
                        stack.pop();
                    }else if(c=='('){
//                        여는 괄호 나오면 어차피 걍 들어감ㅇㅇㅇ
                        stack.push('(');
                    }
                    else{
//                        이제 나머지그 부호들
//                        젤 위에 있는 부호랑 지금 부호랑 우선순위를 비교해서
//                        위에 있는게 크거나 같으면
                        if(map.get(stack.peek()) >= map.get(c)){
                            while(!stack.isEmpty()){
//                                (이게 있을 수도 있고 없을 수도 있잖아 ㅇㅇㅇ
//                                ㅇㅇㅇ
                                if(stack.peek()  == '(')
                                    break;
                                ans += stack.pop();
                            }
                            stack.push(c);
//                            그리고 그거 해줘야 지 이제 그 부등호 넣어줘야지ㅇㅇㅇㅇ
                        }else{
//                            그게 아니면 이제 ㄴㄴ 등호 값이 작으면 걍 넣어주고
                            stack.push(c);
                        }
                    }

                }
                continue;
            }
//            알파벳이면 걍 더해주고
            ans += c;
        }
//        여기가 ㅇㅇ
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
//괄호 들어간 거 까지 가능 함
        System.out.println(ans);
    }
}
