import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        // 각 토핑이 얼마나 등장하는지 세는 맵
        Map<Integer, Integer> rightMap = new HashMap<>();
        Set<Integer> leftSet = new HashSet<>();

        // 우측 집합을 먼저 구성 (전체 토핑을 카운팅)
        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }

        // 하나씩 좌측으로 이동하며 계산
        for (int i = 0; i < n; i++) {
            // 현재 토핑을 좌측 집합에 추가
            leftSet.add(topping[i]);

            // 우측 집합에서 해당 토핑 하나 제거
            rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            if (rightMap.get(topping[i]) == 0) {
                rightMap.remove(topping[i]);
            }

            // 좌측과 우측 집합의 크기가 같으면 answer 증가
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
