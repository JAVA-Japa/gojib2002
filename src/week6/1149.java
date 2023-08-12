import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1][3];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dp = new int[n + 1][3];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = 1 << 30;
                for(int k = 0; k < 3; k++){
                    if(j == k) continue;

                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + arr[i][j]);
                }
            }
        }

        System.out.print(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
