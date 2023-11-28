import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] maze;
    static int N;
    static int M;
    public static void bfs(int a, int b) {
        Queue<Pair> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int newX = 0;
        int newY = 0;
        Pair pair = new Pair(a, b);
        queue.offer(pair);
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) { //상하 좌우 검사
                newX = cur.getX() + dx[i];
                newY = cur.getY() + dy[i];

                if (newX < N && newX > -1 && newY < M && newY > -1) {
                    if (!visited[newX][newY] && maze[newX][newY] == 1) {
                        queue.offer(new Pair(newX, newY));
                        visited[newX][newY] = true;
                        maze[newX][newY] = maze[cur.getX()][cur.getY()] + 1;
                        if (newX == N - 1 && newY == M - 1) {
                            return;
                        }
                    }
                }
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(maze[N-1][M-1]);

    }

    public static class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
