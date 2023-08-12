import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static boolean fin = false;

    public static boolean check(int cur){
        int cnt;

        for(int len = 1; len <= cur / 2; len++){
            cnt = 0;
            for(int i = 0; i < len; i++){
                if(arr[cur - 1 - i] == arr[cur - len - 1 - i]) cnt++;
            }

            if(cnt == len) return false;
        }

        return true;
    }

    public static void recur(int cur){
        if(fin) return;
        if(!check(cur)) return;

        if(cur == n){
            for(int i = 0; i < n; i++){
                System.out.print(arr[i]);
            }

            fin = true;
            return;
        }

        for(int i = 1; i <= 3; i++){
            arr[cur] = i;
            recur(cur + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        recur(0);
    }
}
