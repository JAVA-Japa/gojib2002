import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= j; k += arr[i]){
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        System.out.print(dp[n][m]);
    }
}
