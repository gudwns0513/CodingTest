import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] network;
    static boolean[] visited;
    static int com;
    static int con;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        con = Integer.parseInt(br.readLine());

        network = new int[com+1][com+1];
        visited = new boolean[com+1];

        StringTokenizer st;
        for (int i = 0; i < con; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a][b] = 1;
            network[b][a] = 1;
        }

        bfs(1);
        System.out.println(count);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 1; i < com + 1; i++) {
                if (network[n][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }


    }
}
