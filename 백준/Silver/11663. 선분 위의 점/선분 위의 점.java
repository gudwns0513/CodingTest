import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간복잡도
    N의 최댓값 100,000 M의 최댓값 100,000 O(N^2)으로 모든 경우 찾기 불가능
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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list  = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int startLeft = 0;
            int startRight = list.size() - 1;
            int startIndex = 0;

            int endLeft = 0;
            int endRight = list.size() - 1;
            int endIndex = 0;

            while (startLeft <= startRight) {
                int mid = (startLeft + startRight) / 2;

                //left는 같거나 큰값에 해당 right는 가장 큰 작은값 해당
                if (list.get(mid) < start) {
                    startLeft = mid + 1;
                }else{
                    startRight = mid - 1;
                }
                startIndex = startLeft;
            }

            while(endLeft <= endRight) {
                int mid = (endLeft + endRight) / 2;

                //left는 큰 값에 해당, right는 작거나 같은값에 해당
                if (list.get(mid) <= end) {
                    endLeft = mid + 1;
                } else {
                    endRight = mid - 1;
                }
                endIndex = endRight;
            }

            if (startIndex > endIndex) {
                System.out.println(0);
            }else{
                System.out.println(endIndex - startIndex + 1);
            }
        }
    }
}