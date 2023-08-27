import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] v;
    static boolean[] visited;

    public static void dfs(int cur){
        visited[cur] = true;
        for(int i = 0; i < v[cur].size(); i++){
            if(visited[v[cur].get(i)]) continue;

            dfs(v[cur].get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt;

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

        cnt = 0;
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;

            cnt++;
            dfs(i);
        }

        System.out.print(cnt);
    }
}
