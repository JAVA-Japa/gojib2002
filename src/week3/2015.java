import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n + 1];
        long[] prefix = new long[n + 1];
        TreeMap<Long, Integer> cnt = new TreeMap<>();

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        long ans = 0;
        for(int i = 0; i <= n; i++){
            ans += cnt.getOrDefault(prefix[i] - k, 0);
            cnt.put(prefix[i], cnt.getOrDefault(prefix[i], 0) + 1);
        }

        System.out.print(ans);
    }
}
