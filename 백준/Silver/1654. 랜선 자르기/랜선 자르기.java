import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간복잡도
    N의 최댓값 100,000 M의 최댓값 100,000 O(N^2)으로 모든 경우 찾기 불가능
    O(N(logN + logN)) = O(NlogN)으로 풀었음
    제한시간: 1초

    - 접근
    이분탐색으로 찾아서 출력하기

    - 풀이
    1. 점들을 list에 저장 후 정렬
    2. 선분의 시작점과 끝점이 어느 인덱스안에 있는지 계산
    3. 시작점과 끝점의 인덱스를 빼고 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        long left = 1;
        long right = list.get(list.size() - 1);
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < k; i++) {
                count += list.get(i) / mid;
            }

            if (n <= count) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}