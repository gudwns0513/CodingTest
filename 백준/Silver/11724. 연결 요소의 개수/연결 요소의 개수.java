import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visit;
    static int[][] nodes;
    public static void Dfs(int num) {
        for(int i = 0; i < N; i++){
            if (nodes[num][i] == 1 && visit[i] != true) {
                visit[i] = true;
                Dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new int[N][N];
        visit = new boolean[N];
        Arrays.fill(visit, false);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            nodes[a][b] = 1;
            nodes[b][a] = 1;
        }
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (visit[i] != true) {
                //dfs실행
                visit[i] = true;
                Dfs(i);
                count++;
            }
        }
        System.out.print(count);

    }
}
