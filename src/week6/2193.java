import java.util.Scanner;

public class Main {
    static int n;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dp = new long[n + 1][2];
        dp[1][1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.print(dp[n][0] + dp[n][1]);
    }
}
