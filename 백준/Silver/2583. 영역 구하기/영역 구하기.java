import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int K;
    static int area;
    static int[][] paper;
    static boolean[][] visited;
    static ArrayList<Integer> ary = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = M - y2; j < M - y1; j++) {
                for (int k = x1; k < x2; k++) {
                    paper[j][k] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && paper[i][j] == 0) {
                    dfs(i, j);
                    ary.add(area);
                    area = 0;
                    count++;
                }
            }
        }
        System.out.println(count);
        Collections.sort(ary);
        for (int num : ary) {
            System.out.print(num + " ");
        }
    }
    private static void dfs(int x, int y) {
        area++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newY < 0 || newX > M - 1 || newY > N - 1) {
                continue;
            }

            if (!visited[newX][newY] && paper[newX][newY] == 0) {
                dfs(newX, newY);
            }
        }


    }
}
