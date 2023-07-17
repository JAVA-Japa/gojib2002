import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n + 2][n + 2];
        long[][] prefix = new long[n + 1][n + 1];
        long[][] ans = new long[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int x = Integer.parseInt(st.nextToken());

                arr[i][j] += x;
                arr[i + 1][j] -= x;
                arr[i][j + 1] -= x;
                arr[i + 1][j + 1] += x;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr[i][j];

                long x = -prefix[i][j];
                if(i + m / 2 <= n && j + m / 2 <= n) ans[i + m / 2][j + m / 2] = x;

                prefix[i][j] += x;
                if(j + m <= n) arr[i][j + m] -= x;
                if(i + m <= n) arr[i + m][j] -= x;
                if(i + m <= n && j + m <= n) arr[i + m][j + m] += x;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
