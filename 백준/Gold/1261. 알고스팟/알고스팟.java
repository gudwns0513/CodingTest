import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int minBreakCount = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Point implements Comparable<Point> { //우선순위 큐에서 누굴 기준으로 삼을지 할때 사용
        int x;
        int y;
        int breakCount; //벽을 깬 횟수
        Point(int x, int y, int breakCount) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
        }

        @Override
        public int compareTo(Point o) { //어떤 필드를 기준으로 우선순위를 정할건지 오버라이딩
            return this.breakCount - o.breakCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(minBreakCount);
    }


    //다익스트라사용
    private static void bfs(int x, int y) {
        //벽을 부수는 수가 가장 작은것들을 우선적으로 봄
        PriorityQueue<Point> queue = new PriorityQueue<>(); //기본적으로 오름차순,
        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == N - 1 && p.y == M - 1) { // 가장 먼저 도착한애가 가장 적은 벽 부수기 수를 가짐
                minBreakCount = Math.min(p.breakCount, minBreakCount);
                return;
            }

            for (int i = 0; i < 4; i++) { //위 아래 양옆 확인
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    continue;
                }

                if (!visited[newX][newY]) {
                    if (map[newX][newY] == 1) { //벽을 만나면 +1
                        queue.offer(new Point(newX, newY, p.breakCount + 1));
                    } else { //벽을 안만나면 그대로
                        queue.offer(new Point(newX, newY, p.breakCount));
                    }
                }
                visited[newX][newY] = true;
            }
        }
        //다익스트라 처럼 풀어도되지만 가중치가 0또는 1밖에 없어서 Deque을사용해서 0인경우는 앞에넣고 1인 경우는 뒤에넣어서 앞에서만 사용하는 방식으로
        //하여도 동일함

    }
}
