import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] region;
    static boolean[][] check;
    static int max = 0;
    static int count = 0;
    static int N;

    public static void dfs(int x, int y, int height) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (!check[nextX][nextY] && region[nextX][nextY] > height) {
                    dfs(nextX, nextY, height);
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int count = 0;
        int maxHeight = 0;
        region = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, region[i][j]);
            }
        }

        for (int i = 0; i <= maxHeight; i++) {
            check = new boolean[N][N];
            count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!check[j][k]&& region[j][k] > i) {
                        count++;
                        dfs(j, k, i);
                    }
                }
            }
            max = Math.max(count, max);
        }
        System.out.print(max);
    }
}
