import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] storage;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Node> well = new ArrayList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        storage = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
                if (storage[i][j] == 1) {
                    Node node = new Node();
                    node.setN(i);
                    node.setM(j);
                    well.add(node);
                }
            }
        }
        System.out.print(bfs(well));

    }

    static int bfs(ArrayList<Node> well) {
        if (well.size() == N * M) {
            return 0;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        Queue<Node> queue = new LinkedList<Node>();

        for (int i = 0; i < well.size(); i++) {
            queue.offer(well.get(i));
            int x = well.get(i).getN();
            int y = well.get(i).getM();
            visited[x][y] = true;
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int j = 0; j < n; j++) {
                Node node = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = node.getN() + dx[i];
                    int newY = node.getM() + dy[i];
                    if (newX > -1 && newX < N && newY > -1 && newY < M) {
                        if (visited[newX][newY] != true && storage[newX][newY] == 0) {
                            visited[newX][newY] = true;
                            Node newNode = new Node();
                            newNode.setN(newX);
                            newNode.setM(newY);
                            queue.add(newNode);

                        }
                    }
                }
            }

            count++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] != true && storage[i][j] != -1) {
                    return -1;
                }
            }
        }
        return count-1;


    }
    static class Node {
        private int M;
        private int N;

        public int getN() {
            return N;
        }

        public void setN(int n) {
            N = n;
        }

        public int getM() {
            return M;
        }

        public void setM(int m) {
            M = m;
        }
    }
}


