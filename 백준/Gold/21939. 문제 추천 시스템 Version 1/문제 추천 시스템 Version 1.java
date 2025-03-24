import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 1초

    -접근
    1. TreeMap에 문제 번호, 난이도 저장
    2. 난이도 순으로 정렬
    3. 난이도가 같다면 문제번호가 큰 순으로 정렬
 */
public class Main{
    static class Question{
        int P;
        int L;

        public Question(int p, int l) {
            P = p;
            L = l;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        //난이도 기준 오름차순 정렬, 난이도가 같다면 문제 번호 오름차순 정렬
        TreeSet<Question> set = new TreeSet<>((o1, o2) -> {
            if(o1.L == o2.L){
                return o2.P - o1.P;
            }
            return o2.L - o1.L;
        });

        //문제 번호와 난이도 저장
        Map<Integer, Integer> map = new HashMap<>();

        //기존 문제집 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Question(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "recommend":
                    int num = Integer.parseInt(st.nextToken());

                    if(num == 1){
                        System.out.println(set.first().P);
                    }else{
                        System.out.println(set.last().P);
                    }
                    break;

                case "add":{
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    set.add(new Question(p, l));
                    map.put(p, l);
                    break;
                }
                case "solved":{
                    int p = Integer.parseInt(st.nextToken());
                    int l = map.get(p);
                    set.remove(new Question(p, l));
                    break;
                }


            }
        }
    }


}
