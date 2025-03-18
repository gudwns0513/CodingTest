import java.util.*;

class Solution {

    static boolean visited[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;

    public int solution(String[] board) {
        int answer;
        Point start = null;
        n = board.length;
        m = board[0].length();
        visited = new boolean[n][m];
        //1. 시작점 R 구하기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') start = new Point(i, j, 0);
            }
        }

        //2. BFS 사용
        answer = bfs(start, board);

        return answer;
    }

    public int bfs(Point start, String[] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        
        while (!queue.isEmpty()) {
            //3. 상하좌우 네 방향 탐색
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            if (board[x].charAt(y) == 'G') return current.count;

            for (int i = 0; i < 4; i++) {
                int newX = x;
                int newY = y;

                while (isInBoardAndNotD(newX + dx[i], newY + dy[i], board)) {
                    newX += dx[i];
                    newY += dy[i];
                }

                if(visited[newX][newY]) continue;

                queue.add(new Point(newX, newY, current.count+1));
                visited[newX][newY] = true;
            }
        }
        return -1; // G를 찾지 못한 경우
    }

    public boolean isInBoardAndNotD(int x, int y, String[] board) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x].charAt(y) != 'D';
    }

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
