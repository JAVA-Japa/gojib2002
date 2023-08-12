import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] dp = new int[50][2];

    public static int[] getFibo(int x){
        if(x == 0) return new int[]{1, 0};
        else if(x == 1) return new int[]{0, 1};

        if(dp[x][0] != -1) return dp[x];

        int[] a = getFibo(x - 1);
        int[] b = getFibo(x - 2);

        return dp[x] = new int[]{a[0] + b[0], a[1] + b[1]};

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < 50; i++) dp[i][0] = -1;

        while(t-->0){
            n = Integer.parseInt(br.readLine());

            int[] ans = getFibo(n);

            sb.append(ans[0] + " " + ans[1] + "\n");
        }

        System.out.print(sb);
    }
}
