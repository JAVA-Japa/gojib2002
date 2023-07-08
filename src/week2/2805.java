import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    public static boolean check(int v){
        long sum = 0;

        for(int i = 0; i < n; i++){
            sum += Math.max(0, arr[i] - v);
        }

        return sum >= m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

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
