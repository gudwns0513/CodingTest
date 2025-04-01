import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> cards = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cards);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(cards, numbers.get(i))).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int binarySearch(List<Integer> cards, int target) {
        int left = 0;
        int right = cards.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = cards.get(middle);

            if (middleValue < target) {
                left = middle + 1;
            } else if (middleValue > target) {
                right = middle - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
