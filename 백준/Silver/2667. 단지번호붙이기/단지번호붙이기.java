import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int houseCount = 1;
    static ArrayList<Integer> house = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count++;
                    dfs(i, j);
                    house.add(houseCount);
                    houseCount = 1;
                }
            }
        }
        System.out.println(count);
        Collections.sort(house);
        for (int num : house) {
            System.out.println(num);
        }

    }

    static void dfs(int a, int b) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int newX = a + dx[i];
            int newY = b + dy[i];
            if (newX < 0 || newX > N - 1 || newY < 0 || newY > N - 1) {
                continue;
            }

            if (map[newX][newY] == 1 && !visited[newX][newY]) {
                houseCount++;
                dfs(newX, newY);
            }
        }

    }
}
