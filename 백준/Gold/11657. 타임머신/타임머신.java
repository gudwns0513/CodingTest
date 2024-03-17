import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Edge> edges = new ArrayList<>();
    static long[] dist;

    static long INF = Long.MAX_VALUE;


    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static boolean bellman() {
        dist[1] = 0;
        for (int i = 0; i <= N; i++) {
            for (Edge edge : edges) {
                if(dist[edge.start] == INF)
                    continue;

                if (dist[edge.end] > dist[edge.start] + edge.weight) {
                    dist[edge.end] = dist[edge.start] + edge.weight;

                    if(i == N)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }
        dist = new long[N+1];
        Arrays.fill(dist, INF);

        if (!bellman()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }

            }
        }


    }
}
