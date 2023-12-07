import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] board;
    static boolean[][] visitied;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int x, int y, boolean check) {
        char area = board[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (!check) {
                if (visitied[nx][ny] != true && board[nx][ny] == area) {
                    visitied[nx][ny] = true;
                    dfs(nx, ny, check);
                }
            }
            else {
                if (area == 'B') {
                    if (visitied[nx][ny] != true && board[nx][ny] == area) {
                        visitied[nx][ny] = true;
                        dfs(nx, ny, check);
                    }
                }
                else{
                    if (visitied[nx][ny] != true && (board[nx][ny] == 'R' || board[nx][ny] == 'G')) {
                        visitied[nx][ny] = true;
                        dfs(nx, ny, check);
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visitied = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visitied[i][j] != true) {
                    dfs(i , j, false);
                    count++;
                }
            }
        }

        System.out.print(count);

        count = 0;
        visitied = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visitied[i][j] != true) {
                    dfs(i , j, true);
                    count++;
                }
            }
        }
        System.out.print(" " + count);

    }
}
