package Programmers;

//phone_book의 길이는 1 ~ 1,000,000
//전화번호의 길이는 1 이상 20 이하, 전화번호 중복 없음
//어떤 번호가 다른 것의 접두사면 false
//아니면 true
//접두사 -> string.startsWith

import java.util.*;

class PhonebookList_Prog {
 public boolean solution(String[] phone_book) {
     
     Arrays.sort(phone_book);
     for(int i = 0; i < phone_book.length - 1; i++){
         if(phone_book[i+1].startsWith(phone_book[i])){
             return false;
         }
     }
     
     return true;
 }
}