import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간복잡도
    N의 최댓값 100,000 M의 최댓값 100,000 O(N^2)으로 모든 경우 찾기 불가능

    - 접근
    이분탐색으로 찾아서 출력하기

    - 풀이
    1. 전투력칭호의 최소값 0을 left로, 최댓값을 right로 지정
    2. 이분탐색으로 어느것에 속하는지 탐색
    3. 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        List<Integer> levels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String title = st.nextToken();
            int level = Integer.parseInt(st.nextToken());

            if(!map.containsKey(level)) {
                map.put(level, title);
                levels.add(level);
            }
        }
        StringBuilder sb = new StringBuilder();

        //모든 전투력에 대해 이분탐색 실시
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = levels.size() - 1;
            int target = Integer.parseInt(br.readLine());

            while (left <= right) {
                int middle = (left + right) / 2;
                if (target <= levels.get(middle)) { //target이 작거나 같은 경우를 구해야함
                    right = middle - 1;
                } else{
                    left = middle + 1;
                }
            }
            sb.append(map.get(levels.get(left)) + "\n");
        }

        System.out.println(sb.toString());
    }
}