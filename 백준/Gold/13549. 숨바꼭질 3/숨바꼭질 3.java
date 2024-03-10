import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int N;
    static int K;
    static boolean[] visited;
    static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];


        bfs(N);

        System.out.println(min);


    }

    static class Subin {
        int count;
        int current;

        Subin(int count, int current) {
            this.current = current;
            this.count = count;
        }
    }
    static void bfs(int n) {
        Queue<Subin> queue = new LinkedList<>();
        queue.offer(new Subin(0, n));

        while (!queue.isEmpty()) {
            Subin a = queue.poll();
            visited[a.current] = true;
            if (a.current == K) {
                min = Math.min(min, a.count);
            }
            if (a.current+1 <= max && !visited[a.current+1]) {
                Subin subinP = new Subin(a.count+1, a.current + 1);
                queue.offer(subinP);
            }
            if (a.current-1 >= 0 && !visited[a.current-1]) {
                Subin subinM = new Subin(a.count+1, a.current - 1);
                queue.offer(subinM);
            }
            if (a.current*2 <= max && !visited[a.current*2]) {
                Subin subin2 = new Subin(a.count, a.current * 2);
                queue.offer(subin2);
            }

        }
    }
}
