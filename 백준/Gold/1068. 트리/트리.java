import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초

    -접근
    1. List에 노드 번호와 자식 노드들을 저장
    2. dfs로 리프노드 탐색(이미 방문했거나 삭제된 노드의 자식들은 탐색x

 */
public class Main{
    static boolean[] visited; //방문 노드 저장
    static ArrayList<ArrayList<Integer>> tree; //트리 구조 저장
    static int count = 0; //리프노드 개수
    static int delete;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[n];

        if(n == 0){
            System.out.println(0);
            return;
        }

        //리스트 초기화
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        int root = 0;
        //특정 노드의 자식 노드 번호를 삽입
        for(int i = 0; i < n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                continue;
            }
            tree.get(parent).add(i);
        }

        //삭제할 노드 방문 처리
        delete = Integer.parseInt(br.readLine());
        visited[delete] = true;

        if(delete == root) {
            System.out.println(0);
            return;
        }

        //dfs 탐색 시작(0번 노드가 루트노드가 아닐 수 있음)
        dfs(root);

        System.out.println(count);
    }

    public static void dfs(int current){
        if(visited[current]) return;

        visited[current] = true;

        //리프노드가 삭제된 노드를 자식으로 포함한다면 삭제
        if(tree.get(current).contains(Integer.valueOf(delete))){
            tree.get(current).remove(Integer.valueOf(delete));
        }

        if(tree.get(current).isEmpty()){
            count++;
            return;
        }

        for(int i = 0; i < tree.get(current).size(); i++){
            dfs(tree.get(current).get(i));
        }
    }


}
