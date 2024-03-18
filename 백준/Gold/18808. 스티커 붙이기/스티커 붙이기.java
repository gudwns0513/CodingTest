import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] notebook;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        notebook = new int[N][M]; //노트북
        int[][] sticker; //스티커가 들어갈 2차원 배열



        for (int i = 0; i < K; i++) {
            //스티커 순차적으로 넣기
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];

            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            //------------------------------------------------------

            for (int j = 0; j < 4; j++) {
                if (checkAll(sticker)) {
                    break;
                }else{
                    sticker = rotate(sticker);
                }
            }
        }
        System.out.println(count);
    }
    private static boolean checkAll(int[][] sticker) { //스티커가 붙을 곳이 있다면 붙이고 true반환 없으면 안붙
        for (int i = 0; i <= N - sticker.length; i++) {
            for (int j = 0; j <= M - sticker[0].length; j++) {
                if (checkPoint(i, j, sticker)) {
                    for (int k = i; k < sticker.length + i; k++) {
                        for (int l = j; l < sticker[0].length + j; l++) {
                            if (sticker[k - i][l - j] == 1) {
                                notebook[k][l] = sticker[k-i][l-j];
                                count++;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkPoint(int startX, int startY, int[][] sticker) { //출발점을 정한 스티커 check
        for (int k = startX; k < sticker.length + startX; k++) {
            for (int l = startY; l < sticker[0].length + startY; l++) {
                if(notebook[k][l] == 1 && sticker[k-startX][l-startY] == 1)
                    return false;
            }
        }
        return true;
    }

    private static int[][] rotate(int[][] sticker) { //스티커 시계방향 90도 회전
        int R = sticker[0].length;
        int C = sticker.length;
        int[][] rotateSticker = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotateSticker[i][j] = sticker[C-j-1][i];
            }
        }
        return rotateSticker;
    }
}
