import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간 복잡도
    제한시간 : 2초

    - 접근
    1.
 */

public class Main {
    static int n, m;
    static char[] alpha;
    static boolean[] visited;
    static StringBuilder result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            alpha = br.readLine().toCharArray();
            Arrays.sort(alpha);
            m = alpha.length;
            visited = new boolean[m];
            dfs(0);
        }
        System.out.println(result);
    }

    private static void dfs(int depth) {

        if (depth == m) {
            result.append(sb).append('\n');
        }
        char before = ' ';
        for (int i = 0; i < m; i++) {
            if(!visited[i] && alpha[i] != before) {
                visited[i] = true;
                sb.append(alpha[i]);
                before = alpha[i];
                dfs(depth + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }

        }


    }
}
