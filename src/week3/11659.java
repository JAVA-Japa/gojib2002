import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] prefix = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            sb.append(prefix[b] - prefix[a - 1]);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
