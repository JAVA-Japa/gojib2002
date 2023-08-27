import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 0 || visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n][m];
            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[a][b] = 1;
            }

            int cnt = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0 || visited[i][j]) continue;

                    dfs(i, j);
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
