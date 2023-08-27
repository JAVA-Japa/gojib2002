import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n, m;
    static ArrayList<int[]> v;
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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            int ans = 0;
            v = new ArrayList<>();
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                v.add(new int[]{a, b, c});
                ans += c;
            }

            Collections.sort(v, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return o1[2] - o2[2];
                }
            });

            par = new int[n];
            for(int i = 0; i < n; i++) par[i] = i;

            for(int i = 0; i < v.size(); i++){
                int a = find(v.get(i)[0]);
                int b = find(v.get(i)[1]);

                if(a == b) continue;

                union_(a, b);
                ans -= v.get(i)[2];
            }

            System.out.println(ans);
        }
    }
}
