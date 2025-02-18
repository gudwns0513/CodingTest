import java.io.*;
import java.util.*;

/**
 * 접근
 * 1. 부모를 저장해둘 1차원 배열 parents 생성(int)
 * 2. 방문 여부를 저장해둘 1차원 배열 visited 생성(boolean)
 * 3. 노드들의 연결 상황을 저장해둘 2차원 리스트 tree 생성(List)
 */

public class Main {

    static int[] parents;
    static boolean[] visited;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        parents = new int[n+1]; // 2~n까지
        visited = new boolean[n+1]; // 1~n까지
        tree = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 첫 번째 노드
            int v = Integer.parseInt(st.nextToken()); // 두 번째 노드
            tree[u].add(v); // u와 v가 연결됨
            tree[v].add(u);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void dfs(int current) {
        visited[current] = true;

        for (int next : tree[current]) {
            if (!visited[next]) {
                parents[next] = current; // next의 부모는 current
                dfs(next);
            }
        }
    }
}
