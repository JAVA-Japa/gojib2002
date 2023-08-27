import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n, m;
    static long[][] arr;
    static int[] par;

    public static int find(int x){
        if(par[x] == x) return x;
        else return par[x] = find(par[x]);
    }

    public static void union_(int a, int b){
        a = find(a);
        b = find(b);

        par[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<long[]> v = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new long[n + 1][2];
        for(int i = 1; i <= n; i++){
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }

        par = new int[n + 1];
        for(int i = 1; i <= n; i++) par[i] = i;

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            union_(a, b);
        }

        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                v.add(new long[]{i, j, (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1])});
            }
        }

        Collections.sort(v, new Comparator<long[]>(){
            @Override
            public int compare(long[] o1, long[] o2){
                if(o1[2] > o2[2]) return 1;
                else if(o1[2] == o2[2]) return 0;
                else return -1;
            }
        });

        double ans = 0;
        for(int i = 0; i < v.size(); i++){
            int a = find((int)v.get(i)[0]);
            int b = find((int)v.get(i)[1]);

            if(a == b) continue;

            union_(a, b);
            ans += Math.sqrt(v.get(i)[2]);
        }

        System.out.printf("%.2f", ans);
    }
}
