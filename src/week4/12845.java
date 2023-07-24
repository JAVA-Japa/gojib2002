import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long ans;
        long mx;

        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        ans = 0;
        mx = 0;
        for(int i = 0; i < n; i++){
            ans += arr[i];
            mx = Math.max(mx, arr[i]);
        }

        ans += mx * (n - 2);

        System.out.print(ans);
    }
}
