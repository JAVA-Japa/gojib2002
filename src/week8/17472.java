import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int gcnt;
    static int[] par;

    public static int find(int x){
        if(par[x] == x) return x;
        else return par[x] = find(par[x]);
    }

    public static void union_(int a, int b){
        a = find(a);
        b = find(b);

        par[a] = b;
    }

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void dfs(int x, int y, int gnum){
        visited[x][y] = true;
        arr[x][y] = gnum;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!inRange(nx, ny) || visited[nx][ny] || arr[nx][ny] == 0) continue;

            dfs(nx, ny, gnum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> v = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        gcnt = 0;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || arr[i][j] == 0) continue;

                gcnt++;
                dfs(i, j, gcnt);
            }
        }

        dist = new int[gcnt + 1][gcnt + 1];
        for(int i = 1; i <= gcnt; i++){
            for(int j = 1; j <= gcnt; j++){
                dist[i][j] = 1 << 30;
            }
        }

        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if(arr[x][y] == 0) continue;

                for(int dir = 0; dir < 2; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    while(inRange(nx, ny) && arr[nx][ny] == 0){
                        nx += dx[dir];
                        ny += dy[dir];
                    }

                    if(inRange(nx, ny) && arr[nx][ny] != arr[x][y] && nx - x + ny - y - 1 >= 2){
                        int g1 = arr[x][y];
                        int g2 = arr[nx][ny];

                        dist[g1][g2] = Math.min(dist[g1][g2], nx - x + ny - y - 1);
                        dist[g2][g1] = dist[g1][g2];
                    }
                }
            }
        }

        for(int i = 1; i <= gcnt; i++){
            for(int j = i + 1; j <= gcnt; j++){
                if(dist[i][j] == (1 << 30)) continue;

                v.add(new int[]{i, j, dist[i][j]});
            }
        }

        Collections.sort(v, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });

        par = new int[gcnt + 1];
        for(int i = 1; i <= gcnt; i++) par[i] = i;

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < v.size(); i++){
            int a = find(v.get(i)[0]);
            int b = find(v.get(i)[1]);

            if(a == b) continue;

            union_(a, b);
            ans += v.get(i)[2];
            cnt++;
        }

        if(cnt != gcnt - 1) ans = -1;

        System.out.print(ans);
    }
}
