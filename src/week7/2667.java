import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static String[] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static int dfs(int x, int y){
        int cnt = 1;

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!inRange(nx, ny) || arr[nx].charAt(ny) == '0' || visited[nx][ny]) continue;

            cnt += dfs(nx, ny);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();

        n = sc.nextInt();
        arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i].charAt(j) == '0' || visited[i][j]) continue;

                v.add(dfs(i, j));
            }
        }

        Collections.sort(v);

        System.out.println(v.size());
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.get(i));
        }
    }
}
