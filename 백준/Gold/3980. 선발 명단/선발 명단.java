import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간 복잡도
    제한시간 : 2초

    - 접근
    1.
 */

public class Main {
    static int n;
    static int[][] position;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[11];

        for (int i = 0; i < n; i++) {
            position = new int[11][11];
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    position[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0);
            System.out.println(answer);
            answer = 0;
        }
    }

    static void dfs(int depth, int result) {

        if (depth == 11) {
            answer = Math.max(answer, result);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!visited[i] && position[depth][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, result + position[depth][i]);
                visited[i] = false;
            }
        }
    }
}
