import java.util.Scanner;

public class Main {
    static int n;
    static int[][] dp = new int[1 << 15][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[0][0] = 1;
        for(int i = 1; i < (1 << 8); i++){
            for(int j = 0; j < (1 << 15); j++){
                dp[j][0] = dp[j][0];

                for(int k = 1; k <= 4; k++){
                    dp[j][k] = dp[j][k];

                    if(i * i > j) continue;

                    dp[j][k] += dp[j - i * i][k - 1];
                }
            }
        }

        while(true) {
            n = sc.nextInt();

            if (n == 0) break;

            System.out.println(dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]);
        }
    }
}
