import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int max = 0;
    public static char[][] board;
    public static int n;

    public static void checkBoard(){
        //가로 방향 최대값 찾기
        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 0; j < n-1; j++){
                if(board[i][j] == board[i][j + 1]) count++;
                else count = 1;
                if(count > max) max = count;
            }
        }

        //세로 방향 최대값 찾기
        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 0; j < n-1; j++){
                if(board[j][i] == board[j+1][i]) count++;
                else count = 1;
                if(count > max) max = count;
            }
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = str.charAt(j);
            }
        }
        //가로로 바꿀 때의 최대값 구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(board[i][j] != board[i][j+1]){
                    char temp = board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = temp;

                    checkBoard();

                    temp = board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = temp;
                }
            }
        }

        //세로로 바꿀 때의 최대값 구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(board[j][i] != board[j+1][i]){
                    char temp = board[j][i];
                    board[j][i] = board[j+1][i];
                    board[j+1][i] = temp;

                    checkBoard();

                    temp = board[j][i];
                    board[j][i] = board[j+1][i];
                    board[j+1][i] = temp;
                }
            }
        }

        System.out.print(max);


    }
}