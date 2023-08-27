import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!inRange(nx, ny) || visited[nx][ny] || arr[nx][ny] != arr[x][y]) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt;

        n = sc.nextInt();
        arr = new char[n][n];
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        cnt = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;

                cnt++;
                dfs(i, j);
            }
        }

        System.out.print(cnt + " ");

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 'R') arr[i][j] = 'G';
            }
        }

        cnt = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;

                cnt++;
                dfs(i, j);
            }
        }

        System.out.print(cnt);
    }
}
