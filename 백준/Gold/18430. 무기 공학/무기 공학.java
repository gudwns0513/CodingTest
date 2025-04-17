import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간 복잡도
    제한시간 : 2초
    1 <= N <= 5, 1 <= M <= 5
    중심이 될 수 있는 부분이 N*M만큼 있고 각각의 중심마다 최대 4개의 부메랑을 만들 수 있어 완전 탐색일 경우
    O(4^25)이 나온다.

    - 접근
    부메랑의 중심이 될 부분을 정하고 그 중심으로 만들 수 있는 부메랑을 모두 구해 최댓값 구하기

    -풀이
    1. 부메랑의 중심을 1개 잡는다.
    2. 해당 중심으로 만들 수 있는 부메랑을 for문으로 최대 4가지를 찾는다.
    3. 재귀로 다음 부메랑 중심을 지정하러간다.
    4. 이미 부메랑이 만드는데 사용된 부분은 부메랑의 중심 및 재료로 사용하지 않는다.

 */

public class Main {
    static int[][] wood;
    static int n, m;
    static int answer = 0;
    static boolean[][] visited;
    static int[][] d1 = {{0, 1}, {0, -1}, {0, -1}, {0, 1}};
    static int[][] d2 = {{-1, 0}, {-1, 0}, {1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        wood = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int depth, int sum) {
        if (depth == n * m) {
            answer = Math.max(answer, sum);
            return;
        }

        int x = depth / m;
        int y = depth % m;

        if (!visited[x][y]) {
            //중심 잡기
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int x1 = x + d1[i][0];
                int y1 = y + d1[i][1];
                int x2 = x + d2[i][0];
                int y2 = y + d2[i][1];

                if (possible(x1, y1, x2, y2)) {
                    visited[x1][y1] = true;
                    visited[x2][y2] = true;
                    dfs(depth + 1, sum + wood[x][y] * 2 + wood[x1][y1] + wood[x2][y2]);
                    visited[x1][y1] = false;
                    visited[x2][y2] = false;
                }
            }
            visited[x][y] = false;
        }
        dfs(depth + 1, sum);


    }

    private static boolean possible(int x1, int y1, int x2, int y2) {
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || x1 >= n || y1 >= m || x2 >= n || y2 >= m)
            return false;

        if(visited[x1][y1] || visited[x2][y2]) return false;

        return true;
    }

}
