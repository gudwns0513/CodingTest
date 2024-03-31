import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] alpha;
    static String[] str;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alpha = new boolean[26];
        str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        alpha['a' -'a'] = true;
        alpha['n' -'a'] = true;
        alpha['t' -'a'] = true;
        alpha['i' -'a'] = true;
        alpha['c' -'a'] = true;


        backTracking(0, 0);

        System.out.println(count);
    }
    static void backTracking(int depth, int idx) {
        int check = 0;
        if (depth == K-5) {
            for (int i = 0; i < str.length; i++) {//단어 모두 확인
                boolean read = true;
                for (int j = 0; j < str[i].length(); j++) { //해당 단어의 알파벳 확인
                    if (!alpha[str[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read)
                    check++;
            }

            count = Math.max(count, check);
            return;
        }


        for (int i = idx; i < 26; i++) {
            if (!alpha[i]) {
                alpha[i] = true;
                backTracking(depth + 1,i+1);
                alpha[i] = false;
            }
        }

    }
}
