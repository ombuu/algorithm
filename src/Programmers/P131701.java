package Programmers;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class P131701 {
    /*
    {4,7,9,1,1} -> {4,7,9,1,1,4,7,9,1} 로 늘어뜨려서 계산
    set에 담아서 중복 제거
     */

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        for (int e : elements) {
            arr.add(e);
        }
        arr.addAll(arr);
        arr.remove(arr.size() - 1);

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int k = i; k < i + elements.length; k++) {
                sum += arr.get(k);
                set.add(sum);
            }
        }
        return set.size();
    }

}
