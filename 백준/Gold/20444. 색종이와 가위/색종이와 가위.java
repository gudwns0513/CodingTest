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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n;

        while (left <= right) {
            long row = (left + right) / 2;
            long column = n - row;

            long total = (row + 1) * (column + 1);

            if (total < m) {
                left = row + 1;
            }else if (total > m) {
                right = row - 1;
            }else{
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}