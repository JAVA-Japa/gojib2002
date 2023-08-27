import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n, m;
    static ArrayList<int[]> v = new ArrayList<>();
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
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            v.add(new int[]{a, b, c});
        }

        par = new int[n + 1];
        for(int i = 1; i <= n; i++) par[i] = i;

        Collections.sort(v, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        ans = 0;
        for(int i = 0; i < v.size(); i++){
            int a = find(v.get(i)[0]);
            int b = find(v.get(i)[1]);

            if(a == b) continue;

            union_(a, b);
            ans += v.get(i)[2];
        }

        System.out.print(ans);
    }
}
