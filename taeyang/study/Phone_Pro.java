import java.util.*;

public class Phone_Pro {


    //     phone_book의 길이 1 ~ 1,000,000
//     전화번호 길이 1 ~ 20
//     같은 전화번호는 중복이 없다.
//     사전순으로 정렬하기 -> sorting
//     접두사 찾기 -> startsWith
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        String head = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(head))
                answer = false;
            else
                head = phone_book[i];
        }

        return answer;
    }
}

