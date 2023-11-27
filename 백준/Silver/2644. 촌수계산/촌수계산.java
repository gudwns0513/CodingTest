import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visited;
    public static int bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(a);
        visited[a] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int num : arr[cur]) {
                    if (visited[num] != true) {
                        visited[num] = true;
                        queue.add(num);
                    }
                    if (num == b) {
                        return count;
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        arr = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[parent].add(child);
            arr[child].add(parent);
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.print(bfs(a, b));

    }
}
