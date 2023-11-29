import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] graph;
    static boolean[] visited;

    public static void dfs(int V) {
        if (visited[V] != false) {
            return;
        }
        visited[V] = true;
        System.out.print(V + " ");
        for (int i = 1; i < N + 1; i++) {
            if (graph[V][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur] != true) {
                visited[cur] = true;
                System.out.print(cur + " ");
            }
            for (int i = 1; i < N + 1; i++) {
                if (graph[cur][i] == 1 && visited[i] != true) {
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }
}
