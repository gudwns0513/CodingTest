import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 접근
    1.
 */

public class Main {
    static boolean[] visited;
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new int[m];

        dfs(1,0);
    }

    static void dfs(int start, int depth){

        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= n; i++) {
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
