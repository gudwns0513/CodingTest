import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int safeZone = Integer.MIN_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Virus {
        int x;
        int y;

        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfsWall(0);

        System.out.println(safeZone);

    }

    static void bfs() {
        Queue<Virus> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Virus(i, j));
                }
            }
        }

        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) { // 2차원 배열 복사 방법
            copyMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            copyMap[virus.x][virus.y] = 2;

            for (int k = 0; k < 4; k++) {
                int newX = virus.x + dx[k];
                int newY = virus.y + dy[k];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
                    continue;
                }

                if (copyMap[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.offer(new Virus(newX, newY));
                }



            }
        }

        setSafeZone(copyMap);





    }
    static void setSafeZone(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0)
                    count++;
            }
        }
        safeZone = Math.max(count, safeZone);
    }

    static void  dfsWall(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfsWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
