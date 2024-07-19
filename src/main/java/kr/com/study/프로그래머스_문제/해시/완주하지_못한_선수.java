package kr.com.study.프로그래머스_문제.해시;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 완주하지_못한_선수 {
  public String solution(String[] participant, String[] completion) {
    String answer = "";

    Map<String, Integer> map = new HashMap<>();

    for (String p : participant) {
      if(map.containsKey(p)) {
        map.put(p, map.get(p) + 1);
      } else {
        map.put(p, 1);
      }
    }

    for (String s : completion) {
      map.put(s, map.get(s) + 1);
    }

    for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
      if(stringIntegerEntry.getValue() % 2 != 0) {
        answer = stringIntegerEntry.getKey();
        break;
      }
    }

    return answer;
  }
}
