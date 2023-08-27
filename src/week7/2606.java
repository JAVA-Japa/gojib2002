import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] v;
    static boolean[] visited;

    public static int dfs(int cur){
        int cnt = 1;

        visited[cur] = true;
        for(int i = 0; i < v[cur].size(); i++){
            if(visited[v[cur].get(i)]) continue;

            cnt += dfs(v[cur].get(i));
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        v = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) v[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        visited = new boolean[n + 1];

        System.out.print(dfs(1) - 1);
    }
}
