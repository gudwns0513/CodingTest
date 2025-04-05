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

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = list.get(list.size()-1);

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                if(mid >= list.get(i)) count += list.get(i);
                else count += mid;
            }

            if (count <= m) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}