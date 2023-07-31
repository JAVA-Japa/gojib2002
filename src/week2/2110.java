import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m;
    static ArrayList<Integer> v = new ArrayList<>();

    public static boolean check(int val){
        int cnt = 1;
        int idx = 0;

        for(int i = 1; i < n; i++){
            if(v.get(i) - v.get(idx) >= val){
                cnt++;
                idx = i;
            }
        }

        return cnt >= m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            v.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(v);

        int s = 0;
        int e = 1000000000;
        int ans = 0;
        while(s <= e){
            int mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
