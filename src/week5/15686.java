import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static int[][] arr;
    static ArrayList<int[]> v = new ArrayList<>();
    static ArrayList<int[]> v2 = new ArrayList<>();
    static ArrayList<int[]> tv = new ArrayList<>();
    static int ans;

    public static void recur(int cur, int cnt){
        if(cnt == m){
            int sum = 0;
            for(int i = 0; i < v2.size(); i++){
                int dist = 1 << 30;
                for(int j = 0; j < tv.size(); j++){
                    dist = Math.min(dist, Math.abs(v2.get(i)[0] - tv.get(j)[0]) + Math.abs(v2.get(i)[1] - tv.get(j)[1]));
                }
                sum += dist;
            }

            ans = Math.min(ans, sum);

            return;
        }

        if(cur == v.size()) return;

        tv.add(v.get(cur));
        recur(cur + 1, cnt + 1);
        tv.remove(tv.size() - 1);
        recur(cur + 1, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1) v2.add(new int[]{i, j});
                else if(arr[i][j] == 2) v.add(new int[]{i, j});
            }
        }

        ans = 1 << 30;
        recur(0, 0);

        System.out.print(ans);
    }
}
