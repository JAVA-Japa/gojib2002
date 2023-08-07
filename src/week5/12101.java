import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] arr;
    static int cnt;

    public static void recur(int cur, int sum){
        if(sum > n) return;

        if(sum == n){
            cnt++;

            if(cnt == m){
                System.out.print(arr[0]);
                for(int i = 1; i < cur; i++){
                    System.out.print("+" + arr[i]);
                }
            }

            return;
        }

        for(int i = 1; i <= 3; i++){
            arr[cur] = i;
            recur(cur + 1, sum + i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        recur(0, 0);

        if(cnt < m) System.out.print(-1);
    }
}
