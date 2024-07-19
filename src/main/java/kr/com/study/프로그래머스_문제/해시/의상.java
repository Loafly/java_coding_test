package kr.com.study.프로그래머스_문제.해시;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
  public int solution(String[][] clothes) {
    int answer = 1;

    Map<String, Integer> clothesMap = new HashMap<>();

    for (String[] clothe : clothes) {
      String type = clothe[1];

      if(clothesMap.containsKey(type)) {
        clothesMap.put(type, clothesMap.get(type) + 1);
      } else {
        clothesMap.put(type, 1);
      }
    }

    for (Integer value : clothesMap.values()) {
      answer *= (value + 1);
    }

    return answer - 1;
  }
}
