package kr.com.study.프로그래머스_문제.해시;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class 베스트엘범 {
  public int[] solution(String[] genres, int[] plays) {
    int[] answer = {};

    Map<String, Integer> genresTotalPlaysMap = new HashMap<>();
    Map<String, Map<Integer, Integer>> genresPlaysIndexMap = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      String genre = genres[i];
      int playCount = plays[i];

      if(genresTotalPlaysMap.containsKey(genre)) {
        // 전체 갯수 구하는 Map
        genresTotalPlaysMap.put(genre, genresTotalPlaysMap.get(genre) + playCount);

        Map<Integer, Integer> integerIntegerMap = genresPlaysIndexMap.get(genre);
        integerIntegerMap.put(i, playCount);
        genresPlaysIndexMap.put(genre, integerIntegerMap);
      } else {
        genresTotalPlaysMap.put(genre, playCount);

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        integerIntegerMap.put(i, playCount);
        genresPlaysIndexMap.put(genre, integerIntegerMap);
      }
    }

    List<Entry<String, Integer>> entries = genresTotalPlaysMap.entrySet().stream()
        .sorted(Entry.comparingByValue())
        .collect(Collectors.toList());

    for (Entry<String, Integer> entry : entries) {
      String genrne = entry.getKey();

    }

    return answer;
  }

}
