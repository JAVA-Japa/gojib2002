import java.util.Scanner;

public class Main {
    static int n;
    static int[] dp = new int[1000010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.print(dp[n]);
    }
}
