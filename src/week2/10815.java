import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m;
    static ArrayList<Integer> v = new ArrayList<>();

    public static int check(int val){
        int s = 0;
        int e = n - 1;

        while(s <= e){
            int mid = (s + e) / 2;

            if(v.get(mid) == val) return 1;
            else if(v.get(mid) < val) s = mid + 1;
            else e = mid - 1;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            v.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(v);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(st.nextToken());

            sb.append(check(x) + " ");
        }

        System.out.print(sb);
    }
}
