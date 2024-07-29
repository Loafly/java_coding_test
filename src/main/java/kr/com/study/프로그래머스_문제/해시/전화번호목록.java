package kr.com.study.프로그래머스_문제.해시;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    문제
        - 어떤 번호가 다른 번호의 접두어인 경우가 존재하는지 여부 출력
    조건
        - 1 <= phoneBook.size() <= 1,000,000
        - 각 전화번호(phone)
          -  1 <= phone.size() <= 20
        - 같은 전화번호가 중복 x
 */

public class 전화번호목록 {

  public static void main(String[] args) {
    String[] phoneBook = new String[]{"119", "97674223", "1195524421"};
//    String[] phoneBook = new String[]{"123","456","789"};
//    String[] phoneBook = new String[]{"12","123","1235","567","88"};
    System.out.println(solution(phoneBook));
  }

  public static boolean solution(String[] phone_book) {
    List<String> phoneBooks = Arrays.stream(phone_book)
        .sorted().collect(Collectors.toList());

    for (int i = 0; i < phoneBooks.size() - 1; i++) {
      if(phoneBooks.get(i+1).startsWith(phoneBooks.get(i))) {
        return false;
      }
    }

    return true;
  }
}
