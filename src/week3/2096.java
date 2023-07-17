import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[3];
        int[][] mx = new int[2][3];
        int[][] mn = new int[2][3];
        int ans1, ans2;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                arr[j] = sc.nextInt();
            }

            for(int j = 0; j < 3; j++){
                mx[i % 2][j] = 0;
                mn[i % 2][j] = 1 << 30;

                for(int k = 0; k < 3; k++){
                    if(Math.abs(j - k) == 2) continue;

                    mx[i % 2][j] = Math.max(mx[i % 2][j], mx[(i + 1) % 2][k] + arr[j]);
                    mn[i % 2][j] = Math.min(mn[i % 2][j], mn[(i + 1) % 2][k] + arr[j]);
                }
            }
        }

        ans1 = 0;
        ans2 = 1 << 30;
        for(int i = 0; i < 3; i++){
            ans1 = Math.max(ans1, mx[(n - 1) % 2][i]);
            ans2 = Math.min(ans2, mn[(n - 1) % 2][i]);
        }

        System.out.print(ans1 + " " + ans2);
    }
}
