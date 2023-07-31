import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int ans;
        int sum;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        ans = 0;
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];

            ans += sum;
        }

        System.out.print(ans);
    }
}
