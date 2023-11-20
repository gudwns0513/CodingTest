import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int checkBoard(char[][] board, int start_row, int start_col){
        int change = 0;
        String[] compare = {"BWBWBWBW", "WBWBWBWB"};
        for(int i = start_row; i < start_row + 8; i++){
            int count = 0;
            for(int j = start_col; j < start_col + 8; j++){
                if(i % 2 == 0){
                    if(compare[0].charAt(count++) != board[i][j])
                        change++;
                }
                else{
                    if(compare[1].charAt(count++) != board[i][j])
                        change++;
                }
            }
        }
        return Math.min(change, 64-change);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int min_num = Integer.MAX_VALUE;

        char[][] board = new char[M][N];

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(j);
            }
        }


        for(int i = 0; i <= M-8; i++){
            for(int j = 0; j <= N-8; j++){
               int new_num = checkBoard(board, i, j);
                min_num = Math.min(min_num, new_num);
            }
        }
        System.out.print(min_num);

    }
}
