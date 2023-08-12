import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m, s;
    static ArrayList<Integer>[] v;
    static boolean[] visited;

    public static void dfs(int cur){
        visited[cur] = true;
        System.out.print(cur + " ");

        for(int i = 0; i < v[cur].size(); i++){
            if(visited[v[cur].get(i)]) continue;

            dfs(v[cur].get(i));
        }
    }

    public static void bfs(int s){
        Queue<Integer> que = new LinkedList<>();

        que.add(s);
        visited[s] = true;
        while(!que.isEmpty()){
            int cur = que.poll();

            System.out.print(cur + " ");

            for(int i = 0; i < v[cur].size(); i++){
                if(visited[v[cur].get(i)]) continue;

                que.add(v[cur].get(i));
                visited[v[cur].get(i)] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        v = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) v[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        for(int i = 1; i <= n; i++) Collections.sort(v[i]);

        visited = new boolean[n + 1];
        dfs(s);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(s);
    }
}
