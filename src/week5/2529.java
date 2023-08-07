import java.util.Scanner;

public class Main {
    static int n;
    static String[] v;
    static int[] arr;
    static boolean isFirst = true;
    static boolean[] visited = new boolean[10];
    static int[] ans;

    public static boolean check(int cur){
        if(cur < 2) return true;

        if(v[cur - 2].equals("<") && arr[cur - 2] > arr[cur - 1]) return false;
        if(v[cur - 2].equals(">") && arr[cur - 2] < arr[cur - 1]) return false;

        return true;
    }

    public static void recur(int cur){
        if(!check(cur)) return;

        if(cur == n + 1){
            if(isFirst){
                for(int i = 0; i < n + 1; i++){
                    System.out.print(arr[i]);
                }
                System.out.println();

                isFirst = false;
            }

            for(int i = 0; i < n + 1; i++){
                ans[i] = arr[i];
            }

            return;
        }

        for(int i = 9; i >= 0; i--){
            if(visited[i]) continue;

            visited[i] = true;
            arr[cur] = i;
            recur(cur + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        v = new String[n];
        for(int i = 0; i < n; i++){
            v[i] = sc.next();
        }

        arr = new int[n + 1];
        ans = new int[n + 1];
        recur(0);

        for(int i = 0; i < n + 1; i++){
            System.out.print(ans[i]);
        }
    }
}
