import java.util.Scanner;

public class Main {
    static int n;
    static boolean[][] visited;
    static int cnt;

    public static void recur(int cur){
        if(cur == n){
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[0][i]) continue;
            if(visited[1][cur + i]) continue;
            if(visited[2][cur - i + n]) continue;

            visited[0][i] = true;
            visited[1][cur + i] = true;
            visited[2][cur - i + n] = true;
            recur(cur + 1);
            visited[0][i] = false;
            visited[1][cur + i] = false;
            visited[2][cur - i + n] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[3][3 * n];
        recur(0);

        System.out.print(cnt); 
    }
}
